package pe.andree.retofactusbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pe.andree.retofactusbackend.domain.entities.AppSetting;
import pe.andree.retofactusbackend.domain.entities.Company;
import pe.andree.retofactusbackend.domain.setting.AppSettingsData;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.settings.AppSettingRequestDTO;
import pe.andree.retofactusbackend.dto.response.setting.AppSettingResponseDTO;
import pe.andree.retofactusbackend.mapper.AppSettingMapper;
import pe.andree.retofactusbackend.repository.AppSettingRepository;
import pe.andree.retofactusbackend.repository.CompanyRepository;
import pe.andree.retofactusbackend.service.AppSettingService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppSettingsServiceImpl implements AppSettingService {

    private final AppSettingRepository appSettingRepository;
    private final CompanyRepository companyRepository;

    private final AppSettingMapper appSettingMapper;

    private final FileUploadServiceImpl fileUploadService;

    @Override
    public ApiResponse<AppSettingResponseDTO> addSetting(AppSettingRequestDTO settings, MultipartFile file) {

        Boolean exists = appSettingRepository.existsAppSettingByCompany_Id(settings.getCompanyId());

        if (exists){
            throw new DataIntegrityViolationException("Adjustments have already been made for that company.");
        }

        Company company = companyRepository.findById(settings.getCompanyId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));


        String imgUrl = fileUploadService.uploadFile(file, settings.getCompanyId());

        AppSetting result = appSettingMapper.toAppSetting(settings);

        if (result.getSettings() == null) {
            result.setSettings(new AppSettingsData());
        }

        result.getSettings().getBrandingSettings().setLogoUrl(imgUrl);
        result.setCompany(company);
        result = appSettingRepository.save(result);

        return ApiResponse.<AppSettingResponseDTO>builder()
                .timeStamp(LocalDateTime.now())
                .success(true)
                .message("Settings created")
                .data(appSettingMapper.toSettingResponseDTO(result))
                .build();
    }
}
