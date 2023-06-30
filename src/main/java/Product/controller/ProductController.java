package Product.controller;

import Product.model.Product;
import Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Value("${application.greeting}")
    private String greeting;
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

    @PostMapping
    public Integer productCreate(@RequestBody Product productToCreate) {
        return productRepository.product(productToCreate);
    }

    @GetMapping("/maks")
    public String requestProducts() {
        return """
                cars""";
    }

    @GetMapping("/greet")
    public String greet() {
        return greeting;
    }
}




