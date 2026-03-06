package pe.andree.retofactusbackend.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.andree.retofactusbackend.dto.request.company.CompanyRequestDTO;
import pe.andree.retofactusbackend.dto.response.company.CompanyResponseDTO;
import pe.andree.retofactusbackend.domain.entities.Company;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CompanyMapper {

    private final ModelMapper modelMapper;

    public Company toCompany(CompanyRequestDTO companyRequest){
        return modelMapper.map(companyRequest, Company.class);
    }

    public CompanyResponseDTO toCompanyResponseDTO(Company company){
        return modelMapper.map(company, CompanyResponseDTO.class);
    }

    public List<CompanyResponseDTO> toCompanyResponseDTO(List<Company> companies){
        return companies.stream().map(this::toCompanyResponseDTO).toList();
    }

    public List<Company> toCompany(List<CompanyRequestDTO> companies){
        return companies.stream().map(this::toCompany).toList();
    }
}
