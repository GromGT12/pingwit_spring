package product.controller;

import org.springframework.web.bind.annotation.*;
import product.controller.dto.ProductDTO;
import product.model.Product;
import product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAllProduct();
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productToCreate) {
        return productService.createProduct(productToCreate);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);

    }

    @GetMapping("/search")
    public List<ProductDTO> searchByDescription(@RequestParam String description) {
        return productService.searchByDescription(description);
    }
}




