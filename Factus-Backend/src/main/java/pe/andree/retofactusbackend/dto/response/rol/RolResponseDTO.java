package pe.andree.retofactusbackend.dto.response.rol;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RolResponseDTO {

    private Long id;

    @JsonProperty(namespace = "RolName")
    private Long nameRol;
}
