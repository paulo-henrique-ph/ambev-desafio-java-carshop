package dev.ambev.carshop.util;

import org.springframework.http.HttpStatus;

public interface ApiMessage {
    String getMessage(String... args);

    HttpStatus getStatus();
}
