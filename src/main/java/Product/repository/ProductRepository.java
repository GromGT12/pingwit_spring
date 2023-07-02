package Product.repository;

import Product.model.Product;
import java.util.Collection;

public interface ProductRepository{
    Product getById(Integer id);
    Collection<Product> getAll();
    void delete(Integer productId);
    Integer createProduct(Product productToCreate);
}
