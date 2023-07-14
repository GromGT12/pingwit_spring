package product.Controller;
import product.Controller.ProductDTO.ProductDTO;
import product.Controller.ProductDTO.ProductFilterDTO;
import product.Service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @GetMapping("/search")
    public List<ProductDTO> searchByDescription(@RequestParam String description) {
        LOGGER.info("Searching products by description");
        return productService.searchByDescription(description);
    }

    @GetMapping
    public Collection<ProductDTO> getAll() {
        LOGGER.warn("A request has been received to retrieve all users");
        return productService.getAllProducts();

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        LOGGER.debug("Deleting product with ID");
        productService.deleteProduct(id);

    }

    @PostMapping
    public Integer createProduct(@RequestBody @Valid ProductDTO productToCreate) {
        return productService.createProduct(productToCreate);}

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Integer id, @RequestBody @Valid ProductDTO productToUpdate) {
        return productService.updateProduct(id, productToUpdate);}

    @PostMapping("/search")
    public List<ProductDTO> search(@RequestBody  ProductFilterDTO filter) {
        return productService.search(filter);
    }
    @GetMapping("/page")
    public Page<ProductDTO> getPaged(Pageable pageable) {
        return productService.getPage(pageable);
    }
}
