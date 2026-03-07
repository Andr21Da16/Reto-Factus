package pe.andree.retofactusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.company.CompanyRequestDTO;
import pe.andree.retofactusbackend.dto.request.rol.RolRequestDTO;
import pe.andree.retofactusbackend.dto.response.company.CompanyResponseDTO;
import pe.andree.retofactusbackend.dto.response.rol.RolResponseDTO;
import pe.andree.retofactusbackend.service.CompanyService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/companies")
@Validated
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<ApiResponse<CompanyResponseDTO>> addCompany(@RequestBody CompanyRequestDTO companyRequestDTO){
        ApiResponse<CompanyResponseDTO> response = companyService.addCompany(companyRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CompanyResponseDTO>> findById(@PathVariable Long id){
        ApiResponse<CompanyResponseDTO> response = companyService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCompany(@PathVariable Long id){
        ApiResponse<Void> response = companyService.deleteCompany(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
