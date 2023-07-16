package product.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface SpringDataUserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByNameOrderBySurname(String name);

    List<User> findAllByNameAndSurname(String name, String surname);
}