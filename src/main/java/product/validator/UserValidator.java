package product.validator;


import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;
import product.controller.productDTO.UserDTO;


@Component
public class UserValidator {

    public void validateUser(UserDTO userDTO) {
        if (!userDTO.getEmail().endsWith("@pingwit.pl")) {
            throw new ValidationException("User email should be on @pingwit.pl!");
        }
    }
}
