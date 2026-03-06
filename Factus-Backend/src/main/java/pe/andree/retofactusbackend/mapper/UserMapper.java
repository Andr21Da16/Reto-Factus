package pe.andree.retofactusbackend.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.andree.retofactusbackend.dto.request.auth.SignupRequestDTO;
import pe.andree.retofactusbackend.dto.response.auth.AuthResponseDTO;
import pe.andree.retofactusbackend.dto.response.auth.UserProfileResponseDTO;
import pe.andree.retofactusbackend.domain.entities.User;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public User toUser(SignupRequestDTO signupRequestDTO){
        return modelMapper.map(signupRequestDTO, User.class);
    }

    public UserProfileResponseDTO toUserProfileResponseDTO(User user){
        return modelMapper.map(user, UserProfileResponseDTO.class);
    }

    public AuthResponseDTO toAuthResponseDTO(String token, UserProfileResponseDTO userProfile){
        return AuthResponseDTO.builder().token(token)
                .user(userProfile).build();
    }
}