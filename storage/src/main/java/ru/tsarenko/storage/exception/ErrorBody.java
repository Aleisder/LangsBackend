package ru.tsarenko.storage.exception;

import java.time.LocalDateTime;

/**
 * JSON-object that server returns when an error occurs
 */
public record ErrorBody(
        LocalDateTime timestamp,
        int statusCode,
        String error,
        String path
) {

}