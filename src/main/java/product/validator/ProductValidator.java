package product.validator;

import org.springframework.stereotype.Component;
import product.controller.productDTO.ProductDTO;


@Component
public class ProductValidator {
    public void validateProduct(ProductDTO productDTO) {
        if (productDTO.getName().contains("$")) {
            throw new product.validator.ValidationException("Not found name");
        }
        if (productDTO.getDescription().contains("$")) {
            throw new product.validator.ValidationException("Not found description");

        }
    }
}


