package dev.ambev.carshop.dto.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseDto {
    private final String message;
    private final Instant timestamp;
    private final String field;

    public ErrorResponseDto(String message, String field) {
        this.message = message;
        this.timestamp = Instant.now();
        this.field = field;
    }

    public ErrorResponseDto(String message) {
        this.message = message;
        this.timestamp = Instant.now();
        this.field = null;
    }

    public ErrorResponseDto(FieldError fieldError) {
        this.message = fieldError.getDefaultMessage();
        this.field = fieldError.getField();
        this.timestamp = null;
    }

}
