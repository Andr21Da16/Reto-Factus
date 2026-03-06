package pe.andree.retofactusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.andree.retofactusbackend.entities.AppSetting;

@Repository
public interface AppSettingRepository extends JpaRepository<AppSetting, Long> {

}
