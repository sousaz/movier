package com.desafio.backend;

import com.desafio.backend.entities.Users;
import com.desafio.backend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
		// controla o ciclo de vida
	CommandLineRunner initDatabase(UserRepository userRepository){
		return args -> {
			userRepository.deleteAll();
			Users u = new Users();
			u.setId(UUID.fromString("7a9de783-5167-44da-baf0-e53f558f404e"));
			u.setUsername("sosa");
			u.setPassword("1234");
			userRepository.save(u);
		};
	}

}
