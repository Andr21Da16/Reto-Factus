package pe.andree.retofactusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pe.andree.retofactusbackend.domain.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> , JpaSpecificationExecutor<Rol> {
    boolean existsByNameRol(String nameRol);

}
