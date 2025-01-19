package br.com.FelipeTomazoti.desafioItau.controller.exception;

import br.com.FelipeTomazoti.desafioItau.domain.validator.exception.ValidationExceptionAPI;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintDefinitionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ValidationExceptionAPI.class)
    public ResponseEntity<StandardError> validationException(ValidationExceptionAPI ex, HttpServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage(),
                "Entidade não processável", request.getRequestURI());
        return ResponseEntity.unprocessableEntity().body(error);
    }

}
