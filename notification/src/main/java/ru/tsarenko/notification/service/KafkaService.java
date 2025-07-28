package ru.tsarenko.notification.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    public static final String LANGS_GROUP_ID = "langs";
    public static final String USER_CREATED = "langs-new-user";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendWelcomeEmail(String email) {
        kafkaTemplate.send(USER_CREATED, email);
    }
}
