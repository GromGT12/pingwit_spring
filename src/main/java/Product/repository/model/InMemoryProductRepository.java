package Product.repository.model;

import Product.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryProductRepository {
    private final Map<Integer, Product> products = new HashMap<>();

    @PostConstruct
    public void init() {
        products.put(1, new Product(1, "Iphone 14Pro", "Smartphone", 1200.89));
        products.put(2, new Product(2, "Iphone 12", "Smartphone", 600.56));
        products.put(3, new Product(3, "MacBookAir", "Laptop", 1500.66));
        products.put(4, new Product(4, "Iphone SE 2020", "smartphone", 400.78));
        products.put(5, new Product(5, "AirPods", "headphones", 200.44));
    }


    public Product getById(Integer id) {
        Product product = products.get(id);
        if (product == null) {
            throw new RuntimeException("Product not found");
        } else {
            return product;
        }
    }

    public Collection<Product> getAll() {
        return products.values();
    }

    public void delete(Integer productId) {
        products.remove(productId);
    }

    public Integer createProduct(Product productToCreate) {
        products.put(productToCreate.id(), productToCreate);
        return productToCreate.id();
    }
}

