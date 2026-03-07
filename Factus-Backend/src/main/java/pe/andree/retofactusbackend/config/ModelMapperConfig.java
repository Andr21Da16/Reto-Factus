package pe.andree.retofactusbackend.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.andree.retofactusbackend.domain.entities.AppSetting;
import pe.andree.retofactusbackend.dto.request.settings.AppSettingRequestDTO;
import pe.andree.retofactusbackend.dto.response.auth.UserProfileResponseDTO;
import pe.andree.retofactusbackend.domain.entities.User;
import pe.andree.retofactusbackend.dto.response.setting.AppSettingResponseDTO;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.typeMap(User.class, UserProfileResponseDTO.class).addMappings(m ->
                m.map(src -> src.getRol().getNameRol(), UserProfileResponseDTO::setRole)
        );

        mapper.typeMap(User.class, UserProfileResponseDTO.class).addMappings(m ->
                m.map(src -> src.getCompany().getNameCompany(), UserProfileResponseDTO::setCompany)
        );

        mapper.typeMap(AppSetting.class, AppSettingResponseDTO.class).addMappings(m ->
                m.map(src -> src.getCompany().getNameCompany(), AppSettingResponseDTO::setCompanyName)
        );

        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper;
    }
}