package pe.andree.retofactusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.rol.RolRequestDTO;
import pe.andree.retofactusbackend.dto.response.rol.RolResponseDTO;
import pe.andree.retofactusbackend.service.RolService;


import java.util.List;

@RestController
@RequestMapping("/rol")
@RequiredArgsConstructor
@Validated
public class RolController {

    private final RolService rolService;

    @PostMapping
    public ResponseEntity<ApiResponse<RolResponseDTO>> addRol(@RequestBody RolRequestDTO rolRequest){
        ApiResponse<RolResponseDTO> response = rolService.addRol(rolRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RolResponseDTO>>>
        findFindAllWithFilters(@RequestParam(name = "name", required = false) String rolName, Pageable pageable){
        ApiResponse<List<RolResponseDTO>> response = rolService.findFindAllWithFilters(rolName, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RolResponseDTO>> findById(@PathVariable Long id){
        ApiResponse<RolResponseDTO> response = rolService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<RolResponseDTO>> updateRol(Long id, RolRequestDTO rolRequest){
        ApiResponse<RolResponseDTO> response = rolService.updateRol(id, rolRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRol(@PathVariable Long id){
        ApiResponse<Void> response = rolService.deleteRol(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
