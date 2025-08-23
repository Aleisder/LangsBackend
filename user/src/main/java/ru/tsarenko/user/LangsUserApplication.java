package ru.tsarenko.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
//        scanBasePackages = {
//                "ru.tsarenko.user",
//                "ru.tsarenko.notification",
//                "ru.tsarenko.common.config"
//        }
)
public class LangsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LangsUserApplication.class, args);
    }

}
