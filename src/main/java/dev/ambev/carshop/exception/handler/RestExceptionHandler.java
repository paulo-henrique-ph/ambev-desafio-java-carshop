package dev.ambev.carshop.exception.handler;

import dev.ambev.carshop.dto.exception.ErrorResponseDto;
import dev.ambev.carshop.exception.DomainItemNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DomainItemNotFoundException.class)
    protected ResponseEntity<Object> handleDomainItemNotFoundException(DomainItemNotFoundException ex) {
        final ErrorResponseDto response = new ErrorResponseDto(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getFieldErrors();
        List<ErrorResponseDto> errors = fieldErrors.stream().map(ErrorResponseDto::new).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }
}