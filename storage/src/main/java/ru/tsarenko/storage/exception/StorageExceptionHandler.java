package ru.tsarenko.storage.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class StorageExceptionHandler {

    @ExceptionHandler({NoFileFoundException.class})
    public ResponseEntity<ErrorBody> handle(RuntimeException e, HttpServletRequest request) {
        return new ResponseEntity<>(
                new ErrorBody(
                        LocalDateTime.now(),
                        404,
                        e.getMessage(),
                        request.getRequestURI()
                ),
                HttpStatus.NOT_FOUND
        );
    }
}
