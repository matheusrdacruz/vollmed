package br.com.dars.api_vollmed.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity erroHandler404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erroHandler400(MethodArgumentNotValidException exception){
        var errors = exception.getFieldErrors();
        var errorsValidation = errors.stream()
                .map(ErrorsValidation::new)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorsValidation);
    }

    record ErrorsValidation(String field, String message) {
        public ErrorsValidation(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
