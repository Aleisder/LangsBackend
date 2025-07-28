package ru.tsarenko.langs.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.tsarenko.langs.model.User;
import ru.tsarenko.langs.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserService(UserRepository userRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public User getUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No user with id %d found".formatted(id)));
    }

    public void createUser(String mail) {
        kafkaTemplate.send("langs-new-user", mail);
    }
}
