package Product.service;

import Product.controller.dto.ProductDTO;
import Product.convertor.ProductConvertor;
import Product.model.Product;
import Product.repository.ProductRepository;
import Product.validator.ProductValidator;
import org.springframework.stereotype.Service;

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
        Product product = productRepository.getById(id);
        return productConvertor.convertToDto(product);
    }

    @Override
    public List<Product> createProduct(ProductDTO productToCreate) {
        productValidator.validateProduct(productToCreate);
        Product product = productConvertor.convertEntity(productToCreate);
        return productRepository.createProduct(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public List<ProductDTO> searchById(Integer id) {
        List<Product> products = productRepository.searchById(id);
        return productConvertor.convertorToDto(products);
    }

    @Override
    public List<ProductDTO> searchByName(String name) {
        return null;
    }

    @Override
    public List<ProductDTO> searchByDescription(String description) {
        List<Product> products = productRepository.searchByDescription(description);
        return productConvertor.convertorToDto(products);
    }
}
