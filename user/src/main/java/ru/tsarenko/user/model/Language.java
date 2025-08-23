package ru.tsarenko.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty("id")
    private Integer id;
    @Column(name = "iso_code")
    @Enumerated(EnumType.STRING)
    @JsonProperty("isoProperty")
    private LanguageCode code;
    @JsonProperty("name")
    private String name;
}
