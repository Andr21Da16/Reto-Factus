package pe.andree.retofactusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.andree.retofactusbackend.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findOneByEmail(String email);

    Boolean existsByEmail(String email);
}
