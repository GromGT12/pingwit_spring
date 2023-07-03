package Product.repository;

import Product.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {

    Collection<Product> getAll();

    void deleteProductId(Integer productId);

    List<Product> createProduct(Product productToCreate);

    List<Product> searchProductById(Integer id);

    List<Product> searchByDescription(String description);
}
