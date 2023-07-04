package product.service;

import product.controller.dto.ProductDTO;
import product.convertor.ProductConvertor;
import product.model.Product;
import product.repository.ProductRepository;
import product.validator.ProductValidator;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductConvertor productConvertor;
    private final ProductRepository productRepository;
    private final ProductValidator productValidator;

    public ProductServiceImp(ProductConvertor productConvertor, ProductRepository productRepository, ProductValidator productValidator) {
        this.productConvertor = productConvertor;
        this.productRepository = productRepository;
        this.productValidator = productValidator;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return productConvertor.convertorToDto(productRepository.getAll());
    }

    @Override
    public ProductDTO getById(Integer id) {
        //List<Product> product = Collections.singletonList(productRepository.searchProductById(id));
        Product product = productRepository.searchProductById(id);
        return productConvertor.convertToDto(product);
    }

    @Override
    public Integer createProduct(ProductDTO productToCreate) {
        productValidator.validateProduct(productToCreate);
        Product product = productConvertor.convertEntity(productToCreate);
        return productRepository.createProduct(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteProductId(id);
    }


    @Override
    public List<ProductDTO> searchByDescription(String description) {
       List<Product> products = productRepository.searchByDescription(description);
        return productConvertor.convertorToDto(products);
    }

}
