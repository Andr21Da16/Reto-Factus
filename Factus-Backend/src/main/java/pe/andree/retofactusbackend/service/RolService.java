package pe.andree.retofactusbackend.service;

import org.springframework.data.domain.Pageable;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.rol.RolRequestDTO;
import pe.andree.retofactusbackend.dto.response.rol.RolResponseDTO;



import java.util.List;

public interface RolService {

    ApiResponse<List<RolResponseDTO>> findFindAllWithFilters(String nameRol, Pageable pageable);
    ApiResponse<RolResponseDTO> findById(Long id);
    ApiResponse<RolResponseDTO> addRol(RolRequestDTO rolRequest);
    ApiResponse<RolResponseDTO> updateRol(Long id, RolRequestDTO rolRequest);
    ApiResponse<Void> deleteRol(Long id);
}
