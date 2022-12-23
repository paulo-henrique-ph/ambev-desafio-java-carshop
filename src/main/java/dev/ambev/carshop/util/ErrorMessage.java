package dev.ambev.carshop.util;

import org.flywaydb.core.internal.database.InsertRowLock;
import org.springframework.http.HttpStatus;

public enum ErrorMessage implements ApiMessage {
    CAR_NOT_FOUND("brand.not.found", HttpStatus.NOT_FOUND);

    private final String key;
    private final HttpStatus status;

    ErrorMessage(String key, HttpStatus status) {
        this.key = key;
        this.status = status;
    }

    @Override
    public String getMessage(String... args) {
        return MessageUtil.getMessage(this.key, args);
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }
}
