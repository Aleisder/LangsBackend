package ru.tsarenko.langs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.tsarenko.langs", "ru.tsarenko.notification"})
public class LangsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangsUserApplication.class, args);
	}

}
