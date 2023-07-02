package Product.service;

import Product.controller.dto.ProductDTO;
import Product.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct();

    ProductDTO getById(Integer id);

    List<Product> createProduct(ProductDTO productDTO);

    void deleteById(Integer id);

    List<ProductDTO> searchById(Integer id);

    List<ProductDTO> searchByName(String name);

    List<ProductDTO> searchByDescription(String description);
}
