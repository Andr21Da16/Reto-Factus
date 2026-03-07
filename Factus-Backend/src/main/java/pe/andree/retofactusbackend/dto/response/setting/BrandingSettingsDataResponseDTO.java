package pe.andree.retofactusbackend.dto.response.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandingSettingsDataResponseDTO {
    private String appName;

    private String primaryColor;
    private String secondaryColor;
    private String textColor;
    private String buttonsColor;

    private String logoUrl;
    private String fontFamily;

    private Boolean darkModeEnabled;
}
