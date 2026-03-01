package pe.andree.retofactusbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.andree.retofactusbackend.dto.request.AuthRequestDTO;
import pe.andree.retofactusbackend.dto.request.SignupRequestDTO;
import pe.andree.retofactusbackend.dto.response.AuthResponseDTO;
import pe.andree.retofactusbackend.dto.response.UserProfileResponseDTO;
import pe.andree.retofactusbackend.entities.Rol;
import pe.andree.retofactusbackend.entities.User;
import pe.andree.retofactusbackend.exception.BadRequestException;
import pe.andree.retofactusbackend.exception.ResourceNotFoundException;
import pe.andree.retofactusbackend.mapper.UserMapper;
import pe.andree.retofactusbackend.repository.RolRepository;
import pe.andree.retofactusbackend.repository.UserRepository;
import pe.andree.retofactusbackend.security.TokenProvider;
import pe.andree.retofactusbackend.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private final RolRepository rolRepository;

    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;


    @Override
    @Transactional(readOnly = true)
    public AuthResponseDTO signIn(AuthRequestDTO authRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);


        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = tokenProvider.createAccessToken(authentication);

        UserProfileResponseDTO userProfile = findByEmail(authRequest.getEmail());

        return userMapper.toAuthResponseDTO(accessToken, userProfile);
    }

    @Transactional
    public UserProfileResponseDTO signup(SignupRequestDTO signupRequestDTO){
        boolean emailAlreadyExists = userRepository.existsByEmail(signupRequestDTO.getEmail());

        if (emailAlreadyExists){
            throw new BadRequestException("The email already exits");
        }

        Rol rol = rolRepository.findById(signupRequestDTO.getRolId()).orElseThrow(
                ResourceNotFoundException::new
        );

        User user = userMapper.toUser(signupRequestDTO);
        user.setId(null);
        user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
        //user.setRol(rol);
        userRepository.save(user);
        return userMapper.toUserProfileResponseDTO(user);
    }

    @Transactional(readOnly = true)
    public UserProfileResponseDTO findByEmail(String email) {
        User user = userRepository.findOneByEmail(email)
                .orElseThrow(ResourceNotFoundException::new);

        return userMapper.toUserProfileResponseDTO(user);
    }
}
