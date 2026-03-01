package pe.andree.retofactusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.andree.retofactusbackend.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
