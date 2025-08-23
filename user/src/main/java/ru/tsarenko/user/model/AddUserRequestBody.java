package ru.tsarenko.user.model;

import java.util.Date;
import java.util.List;

public record AddUserRequestBody(
        String name,
        String email,
        Date dateOfBirth,
        LanguageCode nativeLanguage,
        List<LanguageCode> trainingLanguages
) {
}
