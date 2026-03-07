package pe.andree.retofactusbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.settings.AppSettingRequestDTO;
import pe.andree.retofactusbackend.dto.response.setting.AppSettingResponseDTO;


public interface AppSettingService {

    ApiResponse<AppSettingResponseDTO> addSetting(AppSettingRequestDTO settings, MultipartFile file);
}
