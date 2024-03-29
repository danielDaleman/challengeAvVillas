package com.avvillas.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ChallengeAvVillasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeAvVillasApplication.class, args);
	}

}
