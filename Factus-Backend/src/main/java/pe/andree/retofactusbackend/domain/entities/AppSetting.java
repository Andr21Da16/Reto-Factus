package pe.andree.retofactusbackend.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pe.andree.retofactusbackend.domain.setting.AppSettingsData;

@Data
@Entity
@Table(name = "app_settings")
public class AppSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private AppSettingsData settings;


    @OneToOne
    @JoinColumn(name = "company_id", nullable = false, unique = true)
    @JsonBackReference
    private Company company;
}

