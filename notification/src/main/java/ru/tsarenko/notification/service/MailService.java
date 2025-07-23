package ru.tsarenko.notification.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
            topics = "langs-new-user",
            groupId = "langs"
    )
    public void sendMailToNewUser(String mail) {
        SimpleMailMessage message = new SimpleMailMessage() {{
            setFrom(mailUsername);
            setTo(mail);
            setSubject("Welcome to Langs!");
            setText("Thank you for using Langs!");
        }};
        mailSender.send(message);
    }
}
