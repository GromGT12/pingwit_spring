package Product.service;

import Product.controller.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct();

    ProductDTO getById(Integer id);

    Integer createProduct(ProductDTO productDTO);

    void deleteById(Integer id);
}
