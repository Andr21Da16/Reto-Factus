package pe.andree.retofactusbackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.andree.retofactusbackend.dto.response.auth.UserProfileResponseDTO;
import pe.andree.retofactusbackend.domain.entities.User;

@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        // Configuración para mapear rol -> rolName
        mapper.typeMap(User.class, UserProfileResponseDTO.class).addMappings(m ->
                m.map(src -> src.getRol().getNameRol(), UserProfileResponseDTO::setRole)
        );


        // Configuración para mapear rol -> companyName
        mapper.typeMap(User.class, UserProfileResponseDTO.class).addMappings(m ->
                m.map(src -> src.getCompany().getNameCompany(), UserProfileResponseDTO::setCompany)
        );

        return mapper;
    }
}