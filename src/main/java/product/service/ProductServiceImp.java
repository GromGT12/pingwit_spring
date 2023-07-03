package product.service;

import org.springframework.transaction.annotation.Transactional;
import product.controller.dto.ProductDTO;
import product.convertor.ProductConvertor;
import product.model.Product;
import product.repository.SpringDataProductRepository;
import product.validator.ProductValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductConvertor productConvertor;
    private final SpringDataProductRepository springDataProductRepository;
    private final ProductValidator productValidator;

    public ProductServiceImp(ProductConvertor productConvertor, SpringDataProductRepository springDataProductRepository, ProductValidator productValidator) {
        this.productConvertor = productConvertor;
        this.springDataProductRepository = springDataProductRepository;
        this.productValidator = productValidator;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProduct() {
        return productConvertor.convertorToDto((Product) springDataProductRepository.findAll());
    }

    @Override
    public ProductDTO getById(Integer id) {
        Product product = springDataProductRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("product not found" + id));
        return (ProductDTO) productConvertor.convertorToDto(product);
    }

    @Override
    public Integer createProduct(ProductDTO productToCreate) {
        productValidator.validateProduct(productToCreate);
        Product product = productConvertor.convertEntity(productToCreate);
        Product saveProduct = springDataProductRepository.save(product);
        return saveProduct.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteById(Integer id) {
        Product product = springDataProductRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("product not found" + id));
        springDataProductRepository.delete(product);
    }

    @Override
    public List<ProductDTO> searchByDescription(String description) {
       List<Product> productsList = springDataProductRepository.findAllByNameOrderByName(description);
        return productConvertor.convertorToDto((Product) productsList);
    }

}
