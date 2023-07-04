package product.repository;

import product.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {

    Collection<Product> getAll();

    void deleteProductId(Integer productId);

    Integer createProduct(Product productToCreate);

    Product searchProductById(Integer id);

    List<Product> searchByDescription(String description);
}
