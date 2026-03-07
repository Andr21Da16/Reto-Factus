package pe.andree.retofactusbackend.dto.request.settings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandingSettingsDataRequestDTO {

    private String appName;

    private String primaryColor;
    private String secondaryColor;

    private String textColor;
    private String buttonsColor;

    private String fontFamily;

    private Boolean darkModeEnabled;
}
