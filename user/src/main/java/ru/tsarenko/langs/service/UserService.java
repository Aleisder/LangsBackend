package ru.tsarenko.langs.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.tsarenko.langs.model.User;
import ru.tsarenko.langs.repository.UserRepository;
import ru.tsarenko.notification.service.KafkaService;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final KafkaService kafkaService;

    public UserService(UserRepository userRepository, KafkaService kafkaService) {
        this.userRepository = userRepository;
        this.kafkaService = kafkaService;
    }

    public User getUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with id %d found".formatted(id))
                );
    }

    public void createUser(String mail) {
        kafkaService.sendWelcomeEmail(mail);
    }
}
