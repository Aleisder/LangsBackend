package ru.tsarenko.user.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tsarenko.user.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    <S extends User> S save(S entity);
}
