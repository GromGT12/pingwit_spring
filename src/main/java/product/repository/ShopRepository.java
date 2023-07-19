package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.repository.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
}