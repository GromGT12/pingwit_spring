package Product.config.exceptionhandling;

import Product.exсeption.PingwitNotFoundExсeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestExceptionHandler{
    @ExceptionHandler(PingwitNotFoundExсeption.class)
    public ResponseEntity<String> handleNotFoundException(PingwitNotFoundExсeption e){
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }
}
