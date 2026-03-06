package pe.andree.retofactusbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.rol.RolRequestDTO;
import pe.andree.retofactusbackend.dto.response.rol.RolResponseDTO;
import pe.andree.retofactusbackend.entities.Rol;
import pe.andree.retofactusbackend.exception.ResourceNotFoundException;
import pe.andree.retofactusbackend.mapper.MetaMapper;
import pe.andree.retofactusbackend.mapper.RolMapper;
import pe.andree.retofactusbackend.repository.RolRepository;
import pe.andree.retofactusbackend.service.RolService;
import pe.andree.retofactusbackend.util.UtilsFilter;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;


    private final RolMapper rolMapper;
    private final MetaMapper metaMapper;

    @Override
    @Transactional(readOnly = true)
    public ApiResponse<List<RolResponseDTO>> findFindAllWithFilters(String nameRol, Pageable pageable) {
        Specification<Rol> spec =
                Specification.<Rol>where(
                                UtilsFilter.<Rol>stringLike("nameRol", nameRol)
                        );

        Page<Rol> page =
                rolRepository.findAll(spec, pageable);

        Page<RolResponseDTO> dtoPage =
                page.map(rolMapper::toRolResponseDTO);


        return ApiResponse.<List<RolResponseDTO>>builder()
                .success(true)
                .message("Roles retrieved successfully")
                .data(dtoPage.getContent())
                .meta(metaMapper.toMeta(dtoPage))
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<RolResponseDTO> findById(Long id) {

        Rol rol = rolRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Rol not found with ID: " + id
                        )
                );

        return ApiResponse.<RolResponseDTO>builder()
                .success(true)
                .message("Rol retrieved successfully")
                .data(rolMapper.toRolResponseDTO(rol))
                .meta(null)
                .build();
    }

    @Transactional
    @Override
    public ApiResponse<RolResponseDTO> addRol(RolRequestDTO rolRequest) {

        boolean exist = rolRepository.existsByNameRol(rolRequest.getNameRol());
        if (exist) {
            throw new DataIntegrityViolationException("The name rol already exists");
        }

        Rol rol = rolMapper.toRol(rolRequest);
        rolRepository.save(rol);

        return ApiResponse.<RolResponseDTO>builder()
                .timeStamp(LocalDateTime.now())
                .success(true)
                .message("Created rol successfully")
                .data(rolMapper.toRolResponseDTO(rol))
                .build();
    }

    @Transactional
    @Override
    public ApiResponse<RolResponseDTO> updateRol(Long id, RolRequestDTO rolRequest) {
        Rol existing = rolRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Rol not found"
                        )
                );

        existing.setNameRol(rolRequest.getNameRol());


        try {
            existing = rolRepository.save(existing);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException(
                    "Rol already exists"
            );
        }

        return ApiResponse.<RolResponseDTO>builder()
                .success(true)
                .message("Rol updated successfully")
                .data(rolMapper.toRolResponseDTO(existing))
                .meta(null)
                .build();
    }

    @Transactional
    @Override
    public ApiResponse<Void> deleteRol(Long id) {
        Rol existing = rolRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vehicle type not found"
                        )
                );

        rolRepository.delete(existing);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Rol deleted successfully")
                .data(null)
                .meta(null)
                .build();
    }
}
