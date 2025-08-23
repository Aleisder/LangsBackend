package ru.tsarenko.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.tsarenko.storage")
public class LangsStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangsStorageApplication.class, args);
	}

}
