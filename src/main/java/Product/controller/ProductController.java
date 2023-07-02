package Product.controller;

import Product.controller.dto.ProductDTO;
import Product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping("/product")
    public List<ProductDTO> searchByName(@RequestParam String name){
        return productService.searchByName(name);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAllProduct();
    }

    @PostMapping
    public Integer createProduct(@RequestBody ProductDTO productToCreate) {
        return productService.createProduct(productToCreate);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);

    }

}







