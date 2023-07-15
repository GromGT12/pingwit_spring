package product.validator;

import org.springframework.stereotype.Component;
import product.controller.productDTO.ProductDTO;


@Component
public class ProductValidator {
    public void validateProduct(ProductDTO productDTO) {
        if (productDTO.getName().endsWith("$")) {
            throw new product.validator.ValidationException("Not found name");
        }
        if (productDTO.getDescription().endsWith("$")) {
            throw new product.validator.ValidationException("Not found description");

        }
    }
}


