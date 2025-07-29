package ru.tsarenko.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "ru.tsarenko.user",
        "ru.tsarenko.notification.service.KafkaService",
        "ru.tsarenko.notification.service.MailService",
        "ru.tsarenko.common.config.RedisConfig",
})
public class LangsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LangsUserApplication.class, args);
    }

}
