package pe.andree.retofactusbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pe.andree.retofactusbackend.domain.entities.AppSetting;
import pe.andree.retofactusbackend.domain.entities.Company;
import pe.andree.retofactusbackend.domain.entities.User;
import pe.andree.retofactusbackend.domain.setting.AppSettingsData;
import pe.andree.retofactusbackend.domain.setting.BrandingSettingsData;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.settings.AppSettingRequestDTO;
import pe.andree.retofactusbackend.dto.request.settings.BrandingSettingsDataRequestDTO;
import pe.andree.retofactusbackend.dto.response.setting.AppSettingResponseDTO;
import pe.andree.retofactusbackend.dto.response.setting.BrandingSettingsDataResponseDTO;
import pe.andree.retofactusbackend.exception.ResourceNotFoundException;
import pe.andree.retofactusbackend.mapper.AppSettingMapper;
import pe.andree.retofactusbackend.repository.AppSettingRepository;
import pe.andree.retofactusbackend.repository.CompanyRepository;
import pe.andree.retofactusbackend.repository.UserRepository;
import pe.andree.retofactusbackend.service.AppSettingService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppSettingsServiceImpl implements AppSettingService {

    private final AppSettingRepository appSettingRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;


    private final AppSettingMapper appSettingMapper;

    private final FileUploadServiceImpl fileUploadService;


    @Override
    public ApiResponse<AppSettingResponseDTO> addSetting(Long id, AppSettingRequestDTO settings, MultipartFile file) {


        Company company = companyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found."));


        Boolean exists = appSettingRepository.existsAppSettingByCompany_Id(company.getId());

        if (exists){
            throw new DataIntegrityViolationException("Adjustments have already been made for that company.");
        }


        String imgUrl = "";
        if (file != null){
           imgUrl = fileUploadService.uploadFile(file, company.getId());
        }

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

    @Override
    public ApiResponse<BrandingSettingsDataResponseDTO> createBrandingData(BrandingSettingsDataRequestDTO request, MultipartFile file) {
        User user = getUser();
        AppSetting appSetting = appSettingRepository.findByCompanyId(user.getCompany().getId()).
                orElseThrow(() -> new ResourceNotFoundException("No settings found for this company. Cannot add branding data."));

        BrandingSettingsData brandingSetting = appSettingMapper.toBrandingSettingsData(request);

        if (file != null) {
            String urlImg = fileUploadService.uploadFile(file, user.getCompany().getId());
            brandingSetting.setLogoUrl(urlImg);
        }

        appSetting.getSettings().setBrandingSettings(brandingSetting);
        appSetting = appSettingRepository.save(appSetting);
        return ApiResponse.<BrandingSettingsDataResponseDTO>builder()
                .timeStamp(LocalDateTime.now())
                .success(true)
                .message("Settings updated")
                .data(appSettingMapper.toBrandingSettingsDataResponseDTO(appSetting.getSettings().getBrandingSettings()))
                .build();
    }

    @Override
    public ApiResponse<BrandingSettingsDataResponseDTO> updateBrandingData(BrandingSettingsDataRequestDTO request, MultipartFile file) {
        User user = getUser();


        AppSetting appSetting = appSettingRepository.findByCompanyId(user.getCompany().getId()).
                orElseThrow(() -> new ResourceNotFoundException("Settings not found by company Id"));

        BrandingSettingsData brandingSetting = appSettingMapper.toBrandingSettingsData(request);


        String logoUrl = appSetting.getSettings().getBrandingSettings().getLogoUrl();

        if (file != null) {

            if (logoUrl != null && !logoUrl.isEmpty()) {
                fileUploadService.deleteFile(logoUrl);
            }

            String urlImg = fileUploadService.uploadFile(file, user.getCompany().getId());
            brandingSetting.setLogoUrl(urlImg);
        } else {
            // Mantener logo existente si no suben uno nuevo
            brandingSetting.setLogoUrl(logoUrl);
        }

        appSetting.getSettings().setBrandingSettings(brandingSetting);
        appSetting = appSettingRepository.save(appSetting);
        return ApiResponse.<BrandingSettingsDataResponseDTO>builder()
                .timeStamp(LocalDateTime.now())
                .success(true)
                .message("Settings updated")
                .data(appSettingMapper.toBrandingSettingsDataResponseDTO(appSetting.getSettings().getBrandingSettings()))
                .build();
    }

    @Override
    public ApiResponse<BrandingSettingsDataResponseDTO> getBrandingData() {
        User user = getUser();

        AppSetting appSetting = appSettingRepository.findByCompanyId(user.getCompany().getId()).
                orElseThrow(() -> new ResourceNotFoundException("Settings not found by company Id"));

        return ApiResponse.<BrandingSettingsDataResponseDTO>builder()
                .timeStamp(LocalDateTime.now())
                .success(true)
                .message("Branding Data")
                .data(appSettingMapper.toBrandingSettingsDataResponseDTO(appSetting.getSettings().getBrandingSettings()))
                .build();
    }


    private User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findOneByEmail(authentication.getName()).orElseThrow(
                () -> new ResourceNotFoundException("User not found by username")
        );
        return user;
    }
}
