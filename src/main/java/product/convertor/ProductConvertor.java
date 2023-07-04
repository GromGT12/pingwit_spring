package product.convertor;

import org.springframework.stereotype.Component;
import product.controller.dto.ProductDTO;
import product.model.Product;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConvertor {
    public Product convertToEntity(ProductDTO source) {
        return new Product(source.getId(),
                source.getDescription(),
                source.getName(),
                source.getPrice());
    }

    public ProductDTO convertToDto(List<Product> source) {
        return productDTO(source);
    }

    public List<ProductDTO> convertToDto(Collection<Product> source) {
        return source.stream()
                .map(this::productDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO productDTO(Product source) {
        ProductDTO result = new ProductDTO();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setDescription(source.getDescription());
        result.setPrice(source.getPrice());
        return result;
    }
}
