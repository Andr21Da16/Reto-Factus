package pe.andree.retofactusbackend.dto.response.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SettingsResponseDTO {

    private BrandingSettingsDataResponseDTO brandingSettings;
}
