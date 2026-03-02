package pe.andree.retofactusbackend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.AuthRequestDTO;
import pe.andree.retofactusbackend.dto.request.SignupRequestDTO;
import pe.andree.retofactusbackend.dto.response.AuthResponseDTO;
import pe.andree.retofactusbackend.dto.response.UserProfileResponseDTO;
import pe.andree.retofactusbackend.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<ApiResponse<AuthResponseDTO>> signIn(@RequestBody AuthRequestDTO authRequest) {
        ApiResponse<AuthResponseDTO> authResponse = userService.signIn(authRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse<UserProfileResponseDTO>> register(@RequestBody @Validated SignupRequestDTO signupRequestDTO) {
        ApiResponse<UserProfileResponseDTO> userProfileResponseDTO = userService.signup(signupRequestDTO);
        return new ResponseEntity<>(userProfileResponseDTO, HttpStatus.CREATED);
    }

}
