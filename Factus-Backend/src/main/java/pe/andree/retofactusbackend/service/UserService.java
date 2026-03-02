package pe.andree.retofactusbackend.service;

import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.AuthRequestDTO;
import pe.andree.retofactusbackend.dto.request.SignupRequestDTO;
import pe.andree.retofactusbackend.dto.response.AuthResponseDTO;
import pe.andree.retofactusbackend.dto.response.UserProfileResponseDTO;

public interface UserService {

    ApiResponse<AuthResponseDTO> signIn(AuthRequestDTO authRequest);

    ApiResponse<UserProfileResponseDTO> signup(SignupRequestDTO signupRequestDTO);

    UserProfileResponseDTO findByEmail(String email);

}
