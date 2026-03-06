package pe.andree.retofactusbackend.dto.request.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupRequestDTO {

    @NotBlank
    private String firstName;

    @NotBlank(message = "Las name is mandatory")
    private String lastName;

    @NotBlank(message = "Phone is mandatory")
    private String phone;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull(message = "Password is mandatory")
    @Size(min = 4)
    private String password;

    @NotNull(message = "Rol ID is mandatory")
    private Long rolId;

    @NotNull(message = "Company ID is mandatory")
    private Long companyId;


}