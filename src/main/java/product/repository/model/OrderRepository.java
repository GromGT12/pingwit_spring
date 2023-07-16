package product.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface OrderRepository extends JpaRepository<Order, Integer> {
    }

