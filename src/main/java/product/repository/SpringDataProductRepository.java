package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.repository.model.Product;

import java.util.List;

@Repository
public interface SpringDataProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByDescription(String description);

    List<Product> findAllByNameAndDescription(String name, String description);
}