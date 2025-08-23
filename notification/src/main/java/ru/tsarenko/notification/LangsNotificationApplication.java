package ru.tsarenko.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import ru.tsarenko.common.config.MailConfig;

@EnableKafka
@SpringBootApplication(
        scanBasePackages = {
                "ru.tsarenko.notification",
                "ru.tsarenko.common.config"
        }
)
@Import(MailConfig.class)
public class LangsNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LangsNotificationApplication.class, args);
    }

}
