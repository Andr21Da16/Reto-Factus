package pe.andree.retofactusbackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pe.andree.retofactusbackend.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> , JpaSpecificationExecutor<Rol> {
    boolean existsByNameRol(String nameRol);

}
