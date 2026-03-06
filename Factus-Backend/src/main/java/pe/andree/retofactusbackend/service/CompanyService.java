package pe.andree.retofactusbackend.service;

import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.company.CompanyRequestDTO;
import pe.andree.retofactusbackend.dto.response.company.CompanyResponseDTO;

public interface CompanyService {
    ApiResponse<CompanyResponseDTO> addCompany(CompanyRequestDTO company);
    ApiResponse<CompanyResponseDTO> findById(Long id);
    ApiResponse<Void> deleteCompany(Long id);
}
