package com.neolingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NeolingoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeolingoApplication.class, args);
	}

}
