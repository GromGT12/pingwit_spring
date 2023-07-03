package product.service;

import product.controller.dto.ProductDTO;
import product.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct();

    ProductDTO getById(Integer id);

    Product createProduct(ProductDTO productDTO);

    void deleteById(Integer id);

    List<ProductDTO> searchById(Integer id);
    List<ProductDTO> searchByDescription(String description);
}
