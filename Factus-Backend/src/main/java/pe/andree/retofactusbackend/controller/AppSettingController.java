package pe.andree.retofactusbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.settings.AppSettingRequestDTO;
import pe.andree.retofactusbackend.dto.request.settings.BrandingSettingsDataRequestDTO;
import pe.andree.retofactusbackend.dto.response.setting.AppSettingResponseDTO;
import pe.andree.retofactusbackend.dto.response.setting.BrandingSettingsDataResponseDTO;
import pe.andree.retofactusbackend.service.AppSettingService;
import software.amazon.awssdk.thirdparty.jackson.core.JsonProcessingException;


import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/settings")
public class AppSettingController {

    private final AppSettingService appSettingService;

    @GetMapping
    public ResponseEntity<ApiResponse<AppSettingResponseDTO>> getSetting(){
        ApiResponse<AppSettingResponseDTO> response = appSettingService.getSetting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('DEVELOPER')")
    @PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<AppSettingResponseDTO>> addSettings(
            @PathVariable Long id,
            @RequestPart(name = "settings") String settings,
            @RequestPart(name = "file", required = false) MultipartFile file){
        ObjectMapper objectMapper = new ObjectMapper();
        AppSettingRequestDTO request = null;
        try {
            request = objectMapper.readValue(settings, AppSettingRequestDTO.class);
            ApiResponse<AppSettingResponseDTO> response = appSettingService.addSetting(id, request, file);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IOException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exception occurred while parsing the json");
        }
    }

    @GetMapping("/branding")
    public ResponseEntity<ApiResponse<BrandingSettingsDataResponseDTO>> getBrandingData(){
        ApiResponse<BrandingSettingsDataResponseDTO> response = appSettingService.getBrandingData();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/branding")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<BrandingSettingsDataResponseDTO>> createBrandingData(
            @RequestPart(name = "branding") String request,
            @RequestPart(name = "file", required = false) MultipartFile file
            ){

        ObjectMapper objectMapper = new ObjectMapper();
        BrandingSettingsDataRequestDTO branding = null;
        try {
            branding = objectMapper.readValue(request, BrandingSettingsDataRequestDTO.class);
            ApiResponse<BrandingSettingsDataResponseDTO> response = appSettingService.createBrandingData(branding, file);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IOException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exception occurred while parsing the json");
        }
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<BrandingSettingsDataResponseDTO>> updateBrandingData(
            @RequestPart(name = "branding") String request,
            @RequestPart(name = "file", required = false) MultipartFile file
    ){
        ObjectMapper objectMapper = new ObjectMapper();
        BrandingSettingsDataRequestDTO branding = null;
        try {
            branding = objectMapper.readValue(request, BrandingSettingsDataRequestDTO.class);
            ApiResponse<BrandingSettingsDataResponseDTO> response = appSettingService.updateBrandingData(branding, file);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IOException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exception occurred while parsing the json");
        }
    }




}
