package ru.tsarenko.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.tsarenko.langs", "ru.tsarenko.common.config"})
public class LangsEducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangsEducationApplication.class, args);
	}

}
