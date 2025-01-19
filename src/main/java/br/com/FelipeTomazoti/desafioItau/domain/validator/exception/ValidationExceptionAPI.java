
package br.com.FelipeTomazoti.desafioItau.domain.validator.exception;

public class ValidationExceptionAPI extends RuntimeException {
    public ValidationExceptionAPI(String message) {
        super(message);
    }
}
