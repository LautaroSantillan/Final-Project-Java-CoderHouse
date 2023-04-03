package ecommerce.coderhouse.JPA_CoderHouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalHandlerException {
    @ExceptionHandler(ItAlreadyExistsException.class)
    public ResponseEntity<?> itAlreadyExistsException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ItNotFoundException.class)
    public ResponseEntity<?> itNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IdInvalitedException.class)
    public ResponseEntity<?> idInvalitedException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
