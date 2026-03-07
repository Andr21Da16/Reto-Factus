package pe.andree.retofactusbackend.dto.request.settings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingsRequestDTO {

    private BrandingSettingsDataRequestDTO brandingSettings;

}
