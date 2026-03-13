package pe.andree.retofactusbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.auth.AuthRequestDTO;
import pe.andree.retofactusbackend.dto.request.auth.SignupRequestDTO;
import pe.andree.retofactusbackend.dto.response.auth.AuthResponseDTO;
import pe.andree.retofactusbackend.dto.response.auth.UserProfileResponseDTO;
import pe.andree.retofactusbackend.domain.entities.Company;
import pe.andree.retofactusbackend.domain.entities.Rol;
import pe.andree.retofactusbackend.domain.entities.User;
import pe.andree.retofactusbackend.exception.BadRequestException;
import pe.andree.retofactusbackend.exception.ResourceNotFoundException;
import pe.andree.retofactusbackend.mapper.UserMapper;
import pe.andree.retofactusbackend.repository.CompanyRepository;
import pe.andree.retofactusbackend.repository.RolRepository;
import pe.andree.retofactusbackend.repository.UserRepository;
import pe.andree.retofactusbackend.security.TokenProvider;
import pe.andree.retofactusbackend.service.FileUploadService;
import pe.andree.retofactusbackend.service.UserService;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private final RolRepository rolRepository;
    private final CompanyRepository companyRepository;

    private final FileUploadService fileUploadService;

    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;


    @Override
    @Transactional(readOnly = true)
    public ApiResponse<AuthResponseDTO> signIn(AuthRequestDTO authRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);


        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = tokenProvider.createAccessToken(authentication);

        UserProfileResponseDTO userProfile = findByEmail(authRequest.getEmail());


        return ApiResponse.<AuthResponseDTO>builder()
                .timeStamp(LocalDateTime.now())
                .success(true)
                .message("Login successfully")
                .data(userMapper.toAuthResponseDTO(accessToken, userProfile))
                .build();
    }

    @Transactional
    public ApiResponse<UserProfileResponseDTO> signup(SignupRequestDTO signupRequestDTO, MultipartFile file){
        boolean emailAlreadyExists = userRepository.existsByEmail(signupRequestDTO.getEmail());



        if (emailAlreadyExists){
            throw new BadRequestException("The email already exits");
        }

        if (file != null){
            fileUploadService.uploadFile(file, signupRequestDTO.getCompanyId());
        }

        Rol rol = rolRepository.findById(signupRequestDTO.getRolId()).orElseThrow(
                ResourceNotFoundException::new
        );

        Company company = companyRepository.findById(signupRequestDTO.getCompanyId())
                .orElseThrow(ResourceNotFoundException::new);

        User user = userMapper.toUser(signupRequestDTO);
        user.setId(null);
        user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
        user.setRol(rol);
        user.setCompany(company);
        userRepository.save(user);

        return ApiResponse.<UserProfileResponseDTO>builder()
                .timeStamp(LocalDateTime.now())
                .success(true)
                .message("Register successfully")
                .data(userMapper.toUserProfileResponseDTO(user))
                .build();
    }


    @Override
    @Transactional(readOnly = true)
    public UserProfileResponseDTO findByEmail(String email) {
        User user = userRepository.findOneByEmail(email)
                .orElseThrow(ResourceNotFoundException::new);

        return userMapper.toUserProfileResponseDTO(user);
    }
}
