package ru.tsarenko.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.tsarenko.notification.service", "ru.tsarenko.common.config"})
public class LangsUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LangsUserApplication.class, args);
    }

}
