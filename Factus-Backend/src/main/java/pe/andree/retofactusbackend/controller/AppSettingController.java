package pe.andree.retofactusbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.settings.AppSettingRequestDTO;
import pe.andree.retofactusbackend.dto.response.setting.AppSettingResponseDTO;
import pe.andree.retofactusbackend.service.AppSettingService;
import software.amazon.awssdk.thirdparty.jackson.core.JsonProcessingException;


import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/settings")
public class AppSettingController {

    private final AppSettingService appSettingService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<AppSettingResponseDTO>> addSettings(@RequestPart(name = "settings") String settings,
                                                                         @RequestPart(name = "file") MultipartFile file){
        ObjectMapper objectMapper = new ObjectMapper();
        AppSettingRequestDTO request = null;
        try {
            request = objectMapper.readValue(settings, AppSettingRequestDTO.class);
            ApiResponse<AppSettingResponseDTO> response = appSettingService.addSetting(request, file);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IOException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exception occurred while parsing the json");
        }
    }

}
