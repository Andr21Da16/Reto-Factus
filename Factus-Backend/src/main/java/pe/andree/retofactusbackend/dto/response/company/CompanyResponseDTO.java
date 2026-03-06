package pe.andree.retofactusbackend.dto.response.company;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponseDTO {

    private Long id;
    private String nameCompany;
    private String rucNit;
    private String taxAddress;
    private String phone;
}
