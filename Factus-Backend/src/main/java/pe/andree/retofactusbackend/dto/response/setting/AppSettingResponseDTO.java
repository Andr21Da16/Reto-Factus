package pe.andree.retofactusbackend.dto.response.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppSettingResponseDTO {

    private Long id;
    private String companyName;
    private SettingsResponseDTO settings;
}
