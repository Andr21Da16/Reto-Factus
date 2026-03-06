package pe.andree.retofactusbackend.service;

import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.auth.AuthRequestDTO;
import pe.andree.retofactusbackend.dto.request.auth.SignupRequestDTO;
import pe.andree.retofactusbackend.dto.response.auth.AuthResponseDTO;
import pe.andree.retofactusbackend.dto.response.auth.UserProfileResponseDTO;

public interface UserService {

    ApiResponse<AuthResponseDTO> signIn(AuthRequestDTO authRequest);

    ApiResponse<UserProfileResponseDTO> signup(SignupRequestDTO signupRequestDTO);

    UserProfileResponseDTO findByEmail(String email);

}
