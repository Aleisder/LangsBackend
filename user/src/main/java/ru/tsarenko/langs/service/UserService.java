package ru.tsarenko.langs.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createUser(String mail) {
        kafkaTemplate.send("langs-new-user", mail);
    }
}
