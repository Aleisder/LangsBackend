package ru.tsarenko.user.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tsarenko.user.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
