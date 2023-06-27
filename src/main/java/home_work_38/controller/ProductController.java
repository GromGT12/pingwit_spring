package home_work_38.controller;

import home_work_38.model.Product;
import home_work_38.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return productRepository.getById(id);
    }

    @GetMapping
    public Collection<Product> getAll() {
        return productRepository.getAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        productRepository.delete(id);
        return "correct";
    }

    @GetMapping("/maks")
    public String requestProducts() {
        return """
                          "<html><body><h1>
                          "Iphone 14Pro", "Smartphone", 1200.89));
                          "Iphone 12", "Smartphone", 600.56));
                          "MacBookAir", "Laptop", 1500.66));
                          "Iphone SE 2020", "smartphone", 400.78));
                          "AirPods", "headphones", 200.44));
                           !</h1></body></html>";
                """;
    }
}




