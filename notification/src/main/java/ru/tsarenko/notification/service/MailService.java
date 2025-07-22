package ru.tsarenko.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @KafkaListener(
            topics = "langs-new-user",
            groupId = "langs"
    )
    public void sendMailToNewUser(String mail) {
        System.out.println(mail);
    }
}
