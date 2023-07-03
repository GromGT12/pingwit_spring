package product.convertor;

import product.controller.dto.ProductDTO;
import product.model.Product;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConvertor {
    public Product convertEntity(ProductDTO source) {
        return new Product(source.getId(),
                source.getDescription(),
                source.getName(),
                source.getPrice());
    }

    public ProductDTO convertToDto(Product source) {
        return productDTO(source);
    }

    public List<ProductDTO> convertorToDto(Collection<Product> source) {
        return source.stream()
                .map(this::productDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO productDTO(Product source) {
        ProductDTO result = new ProductDTO();
        result.setId(source.id());
        result.setName(source.name());
        result.setDescription(source.description());
        result.setPrice(source.price());
        return result;
    }
}
