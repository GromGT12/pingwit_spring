package product.config.exceptionhandling;

import jakarta.validation.ValidationException;
import product.exсeption.PingwitNotFoundExсeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({PingwitNotFoundExсeption.class})
    public ResponseEntity<String> handleNotFoundException(PingwitNotFoundExсeption e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }
     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
    }
}
