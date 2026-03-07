package pe.andree.retofactusbackend.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.andree.retofactusbackend.domain.entities.AppSetting;
import pe.andree.retofactusbackend.domain.setting.BrandingSettingsData;
import pe.andree.retofactusbackend.dto.request.settings.AppSettingRequestDTO;
import pe.andree.retofactusbackend.dto.request.settings.BrandingSettingsDataRequestDTO;
import pe.andree.retofactusbackend.dto.response.setting.AppSettingResponseDTO;
import pe.andree.retofactusbackend.dto.response.setting.BrandingSettingsDataResponseDTO;
import pe.andree.retofactusbackend.dto.response.setting.SettingsResponseDTO;

@Component
@RequiredArgsConstructor
public class AppSettingMapper {

    private final ModelMapper modelMapper;

    public AppSetting toAppSetting(AppSettingRequestDTO appSetting){
        return modelMapper.map(appSetting, AppSetting.class);
    }

    public AppSettingResponseDTO toSettingResponseDTO(AppSetting appSetting){
        return modelMapper.map(appSetting, AppSettingResponseDTO.class);
    }

    public BrandingSettingsDataResponseDTO toBrandingSettingsDataResponseDTO(BrandingSettingsData brandingSettings){
        return modelMapper.map(brandingSettings, BrandingSettingsDataResponseDTO.class);
    }
    public BrandingSettingsData toBrandingSettingsData(BrandingSettingsDataRequestDTO brandingSettings){
        return modelMapper.map(brandingSettings, BrandingSettingsData.class);
    }
}
