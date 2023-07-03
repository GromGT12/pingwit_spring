package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.model.Product;

import java.util.List;

@Repository
public interface SpringDataProductRepository extends JpaRepository<Product, Integer>{
     List<Product> findAllByNameOrderByName(String description);

}
