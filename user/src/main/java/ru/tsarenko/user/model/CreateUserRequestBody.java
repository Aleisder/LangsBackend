package ru.tsarenko.user.model;

import java.util.Date;

public record CreateUserRequestBody(
        String name,
        String email,
        Date dateOfBirth

) {
}
