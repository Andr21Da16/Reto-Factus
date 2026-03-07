package pe.andree.retofactusbackend.dto.request.settings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppSettingRequestDTO {

    private Long companyId;
    private SettingsRequestDTO appSetting;
}
