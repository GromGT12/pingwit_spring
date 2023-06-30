package Product.controller;

import Product.controller.dto.ProductDTO;
import Product.convertor.ProductConvertor;
import Product.model.Product;
import Product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductConvertor productConvertor;
    private final ProductRepository productRepository;

    public ProductController(ProductConvertor productConvertor, ProductRepository productRepository) {
        this.productConvertor = productConvertor;
        this.productRepository = productRepository;
    }

    //доастали по id hibarenate entity наш потенциальный и пользователям вернули сконвертированый объект
    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Integer id) {
        Product product = productRepository.getById(id);
        return productConvertor.convertToDto(product);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productConvertor.convertorToDto(productRepository.getAll());
    }

    @PostMapping
    public Integer createProduct(@RequestBody ProductDTO productToCreate) {
        Product product = productConvertor.convertEntity(productToCreate);
        return productRepository.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        productRepository.delete(id);
        return "correct";
    }
}






