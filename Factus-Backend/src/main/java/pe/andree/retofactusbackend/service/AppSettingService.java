package pe.andree.retofactusbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.settings.AppSettingRequestDTO;
import pe.andree.retofactusbackend.dto.request.settings.BrandingSettingsDataRequestDTO;
import pe.andree.retofactusbackend.dto.response.setting.AppSettingResponseDTO;
import pe.andree.retofactusbackend.dto.response.setting.BrandingSettingsDataResponseDTO;


public interface AppSettingService {

    ApiResponse<AppSettingResponseDTO> getSetting();
    ApiResponse<AppSettingResponseDTO> addSetting(Long id, AppSettingRequestDTO settings, MultipartFile file);
    ApiResponse<BrandingSettingsDataResponseDTO> createBrandingData(BrandingSettingsDataRequestDTO request, MultipartFile file);
    ApiResponse<BrandingSettingsDataResponseDTO> updateBrandingData(BrandingSettingsDataRequestDTO request, MultipartFile file);
    ApiResponse<BrandingSettingsDataResponseDTO> getBrandingData();

}
