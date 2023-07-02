package Product.repository;

import Product.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {
    Product getById(Integer id);

    Collection<Product> getAll();

    void delete(Integer productId);

    void deleteProductId(Integer id);

    List<Product> createProduct(Product productToCreate);

    List<Product> searchById(Integer id);

    List<Product> searchProductById(Integer id);

    List<Product> searchByDescription(String description);
}
