package ru.tsarenko.langs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tsarenko.langs.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
