package ru.tsarenko.user.model;

public enum LanguageCode {
    RU("Russian"),
    EN("English"),
    DE("German"),
    ES("Spanish");

    private final String name;

    LanguageCode(String name) {
        this.name = name;
    }
}
