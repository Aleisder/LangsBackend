package ru.tsarenko.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class LangsNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangsNotificationApplication.class, args);
	}

}
