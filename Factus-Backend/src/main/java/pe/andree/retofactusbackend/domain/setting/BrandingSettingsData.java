package pe.andree.retofactusbackend.domain.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandingSettingsData {

    private String appName;

    private String primaryColor;
    private String secondaryColor;
    private String textColor;
    private String buttonsColor;

    private String logoUrl;
    private String faviconUrl;
    private String fontFamily;

    private Boolean darkModeEnabled;

}