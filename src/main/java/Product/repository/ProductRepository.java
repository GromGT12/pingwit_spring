package Product.repository;

import Product.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {
    Product getById(Integer id);

    Collection<Product> getAll();

    void delete(Integer productId);

    Integer createProduct(Product productToCreate);

    List<Product> searchBy(Integer id);

    List<Product> searchByDescription(String description);
}
