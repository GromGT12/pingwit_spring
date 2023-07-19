package product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import product.repository.model.Product;

public interface PagingProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
