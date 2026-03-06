package pe.andree.retofactusbackend.dto.request.rol;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolRequestDTO {

    @NotBlank
    @JsonProperty(namespace = "RolName")
    private String nameRol;
}
