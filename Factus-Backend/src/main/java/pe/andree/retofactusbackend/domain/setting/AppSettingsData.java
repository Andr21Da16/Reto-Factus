package pe.andree.retofactusbackend.domain.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppSettingsData {

    private BrandingSettingsData brandingSettings = new BrandingSettingsData();
}
