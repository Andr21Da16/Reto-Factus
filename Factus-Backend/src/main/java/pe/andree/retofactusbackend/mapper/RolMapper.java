package pe.andree.retofactusbackend.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.andree.retofactusbackend.dto.request.rol.RolRequestDTO;
import pe.andree.retofactusbackend.dto.response.rol.RolResponseDTO;
import pe.andree.retofactusbackend.entities.Rol;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RolMapper {

    private final ModelMapper modelMapper;

    public RolResponseDTO toRolResponseDTO(Rol rol) {
        return modelMapper.map(rol, RolResponseDTO.class);
    }

    public Rol toRol(RolRequestDTO rolRequest){
        return modelMapper.map(rolRequest, Rol.class);
    }

    public List<RolResponseDTO> toRolResponseDTO(List<Rol> rol){
        return rol.stream().map(this::toRolResponseDTO).toList();
    }
}
