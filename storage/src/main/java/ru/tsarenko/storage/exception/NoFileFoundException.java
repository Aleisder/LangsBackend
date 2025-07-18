package ru.tsarenko.storage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFileFoundException extends RuntimeException{
    public NoFileFoundException(String message) {
        super(String.format("No filename with name \"%s\"", message));
    }
}
