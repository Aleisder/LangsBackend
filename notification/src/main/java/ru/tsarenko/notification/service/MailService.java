package ru.tsarenko.notification.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static ru.tsarenko.notification.service.KafkaService.LANGS_GROUP_ID;
import static ru.tsarenko.notification.service.KafkaService.USER_CREATED;

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final String mailUsername;

    public MailService(
            JavaMailSender mailSender,
            @Value("${spring.mail.username}") String mailUsername
    ) {
        this.mailSender = mailSender;
        this.mailUsername = mailUsername;
    }

    @KafkaListener(
            topics = USER_CREATED,
            groupId = LANGS_GROUP_ID
    )
    public void sendMailToNewUser(String mail) {
        var message = new SimpleMailMessage();
        message.setFrom(mailUsername);
        message.setTo(mail);
        message.setSubject("Welcome to Langs!");
        message.setText("Thank you for using Langs!");
        mailSender.send(message);
    }
}
