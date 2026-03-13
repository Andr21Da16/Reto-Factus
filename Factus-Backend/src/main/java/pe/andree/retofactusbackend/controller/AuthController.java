package pe.andree.retofactusbackend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.auth.AuthRequestDTO;
import pe.andree.retofactusbackend.dto.request.auth.SignupRequestDTO;
import pe.andree.retofactusbackend.dto.request.settings.BrandingSettingsDataRequestDTO;
import pe.andree.retofactusbackend.dto.response.auth.AuthResponseDTO;
import pe.andree.retofactusbackend.dto.response.auth.UserProfileResponseDTO;
import pe.andree.retofactusbackend.dto.response.setting.BrandingSettingsDataResponseDTO;
import pe.andree.retofactusbackend.service.UserService;

import java.io.IOException;

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
    public ResponseEntity<ApiResponse<UserProfileResponseDTO>> register(@RequestPart(name = "user") @Validated String signupRequestDTO, @RequestPart(name = "file",required = false)MultipartFile file) {

        ObjectMapper objectMapper = new ObjectMapper();
        SignupRequestDTO user = null;
        try {
            user = objectMapper.readValue(signupRequestDTO, SignupRequestDTO.class);
            ApiResponse<UserProfileResponseDTO> response = userService.signup(user, file);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IOException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exception occurred while parsing the json");
        }
    }


    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserProfileResponseDTO>> me(Authentication authentication) {

        UserProfileResponseDTO response = userService.findByEmail(authentication.getName());

        return ResponseEntity.ok(ApiResponse.<UserProfileResponseDTO>builder()
                .success(true)
                .message("Usuario autenticado")
                .data(response)
                .build()
        );
    }
}
