package pe.andree.retofactusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.andree.retofactusbackend.domain.entities.Company;
import pe.andree.retofactusbackend.domain.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findOneByEmail(String email);

    Boolean existsByEmail(String email);

    User findUserByCompany(Company company);
}
