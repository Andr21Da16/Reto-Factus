package pe.andree.retofactusbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.andree.retofactusbackend.dto.ApiResponse;
import pe.andree.retofactusbackend.dto.request.company.CompanyRequestDTO;
import pe.andree.retofactusbackend.dto.response.company.CompanyResponseDTO;
import pe.andree.retofactusbackend.domain.entities.Company;
import pe.andree.retofactusbackend.exception.ResourceNotFoundException;
import pe.andree.retofactusbackend.mapper.CompanyMapper;
import pe.andree.retofactusbackend.repository.CompanyRepository;
import pe.andree.retofactusbackend.service.CompanyService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    @Transactional
    public ApiResponse<CompanyResponseDTO> addCompany(CompanyRequestDTO companyRequest) {
        boolean exist = companyRepository.existsCompanyByNameCompany(companyRequest.getNameCompany());
        boolean aux = companyRepository.existsCompanyByRucNit(companyRequest.getRucNit());

        if (exist || aux) {
            throw new DataIntegrityViolationException("The name rol already exists");
        }

        Company company = companyMapper.toCompany(companyRequest);
        companyRepository.save(company);

        return ApiResponse.<CompanyResponseDTO>builder()
                .timeStamp(LocalDateTime.now())
                .success(true)
                .message("Created company successfully")
                .data(companyMapper.toCompanyResponseDTO(company))
                .build();
    }

    @Override
    public ApiResponse<CompanyResponseDTO> findById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Company not found with ID: " + id
                        )
                );

        return ApiResponse.<CompanyResponseDTO>builder()
                .success(true)
                .message("Company retrieved successfully")
                .data(companyMapper.toCompanyResponseDTO(company))
                .meta(null)
                .build();
    }

    @Override
    public ApiResponse<Void> deleteCompany(Long id) {
        Company existing = companyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vehicle type not found"
                        )
                );

        companyRepository.delete(existing);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Company deleted successfully")
                .data(null)
                .meta(null)
                .build();

    }
}
