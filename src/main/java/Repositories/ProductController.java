package Repositories;

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

    @GetMapping("/Product")
    @ResponseBody
    public Collection<Product> getAll() {
        return productRepository.getAll();
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        productRepository.delete(id);
        return "correct";
    }
}





