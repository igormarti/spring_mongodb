package com.imr.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.imr.workshopmongo.domain.User;
import com.imr.workshopmongo.repositories.UserRepository;

@Configuration
public class SeedRun implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User us1 = new User("Igor Martins", "igor@test.com");
		User us2 = new User("Juliana Martins", "ju@test.com");

		userRepository.saveAll(Arrays.asList(us1, us2));

	}

}
