package Product.Service;

import Product.Controller.ProductDTO.ProductDTO;
import Product.Controller.ProductDTO.ProductFilterDTO;
import Product.Convertor.ProductConverter;
import Product.Repository.PagingProductRepository;
import Product.Repository.Product;
import Product.Repository.SpringDataProductRepository;
import Product.exсeption.PingwitNotFoundExсeption;
import Product.validator.ProductValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final SpringDataProductRepository springDataProductRepository;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;
    private final PagingProductRepository pagingProductRepository;

    public ProductServiceImpl(SpringDataProductRepository springDataProductRepository, ProductConverter productConverter, ProductValidator productValidator, PagingProductRepository pagingProductRepository) {
        this.springDataProductRepository = springDataProductRepository;
        this.productConverter = productConverter;
        this.productValidator = productValidator;
        this.pagingProductRepository = pagingProductRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        Collection<Product> all = springDataProductRepository.findAll();
        return productConverter.convertToDto(all);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getById(Integer id) {
        Product product = springDataProductRepository.findById(id).orElseThrow(() -> new PingwitNotFoundExсeption("Product not found" + id));
        return productConverter.convertToDto(product);
    }

    @Override
    @Transactional
    public Integer createProduct(ProductDTO productToCreate) {
        productValidator.validateProduct(productToCreate);
        Product product = productConverter.convertToEntity(productToCreate);
        Product saveProduct = springDataProductRepository.save(product);
        return saveProduct.getId();
    }

    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        Product product = springDataProductRepository.findById(id).orElseThrow(() -> new PingwitNotFoundExсeption("Product not found" + id));
        springDataProductRepository.delete(product);

    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> searchByDescription(String description) {
        List<Product> productsList = springDataProductRepository.findAllByDescription(description);
        return productConverter.convertToDto(productsList);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productToUpdate) {
        Product product = springDataProductRepository.findById(id).orElseThrow(() -> new PingwitNotFoundExсeption("Product not found" + id));
        Product entityToUpdate = productConverter.convertToEntity(productToUpdate);
        entityToUpdate.setId(id);
        Product updateEntity = springDataProductRepository.save(entityToUpdate);
        return productConverter.convertToDto(updateEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> search(ProductFilterDTO filter) {
        List<Product> allByNameAndDescription = springDataProductRepository.findAllByNameAndDescription(filter.getName(), filter.getDescription());
        return productConverter.convertToDto(allByNameAndDescription);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDTO> getPage(Pageable pageable) {
        Page<Product> productPage = pagingProductRepository.findAll(pageable);
        List<ProductDTO> productDTOS = productConverter.convertToDto(productPage.getContent());
        return new PageImpl<>(productDTOS, productPage.getPageable(), productPage.getTotalPages());
    }
}