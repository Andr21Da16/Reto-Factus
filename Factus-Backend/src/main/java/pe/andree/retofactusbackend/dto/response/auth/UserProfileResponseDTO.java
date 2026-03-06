package pe.andree.retofactusbackend.dto.response.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String role;

}
