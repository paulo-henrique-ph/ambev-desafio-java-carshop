package dev.ambev.carshop.exception;

import dev.ambev.carshop.util.ApiMessage;
import org.springframework.http.HttpStatus;


public class DomainItemNotFoundException extends RuntimeException {

    private final String message;
    private final HttpStatus status;

    public DomainItemNotFoundException(ApiMessage apiMessage, String... args) {
        this.message = apiMessage.getMessage(args);
        this.status = apiMessage.getStatus();
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
