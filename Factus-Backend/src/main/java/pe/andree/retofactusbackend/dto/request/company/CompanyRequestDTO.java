package pe.andree.retofactusbackend.dto.request.company;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDTO {


    @NotBlank
    private String nameCompany;

    @NotBlank()
    private String rucNit;

    @NotBlank
    private String taxAddress;

    @NotBlank
    private String phone;
}
