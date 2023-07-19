package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.repository.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}

