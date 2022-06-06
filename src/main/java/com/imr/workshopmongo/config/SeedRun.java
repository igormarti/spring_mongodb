package com.imr.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import com.imr.workshopmongo.domain.Post;
import com.imr.workshopmongo.domain.User;
import com.imr.workshopmongo.repositories.PostRepository;
import com.imr.workshopmongo.repositories.UserRepository;

@Configuration
public class SeedRun implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();

		User us1 = new User("Igor Martins", "igor@test.com");
		User us2 = new User("Juliana Martins", "ju@test.com");
		
		Post p1 =  new Post(null, Instant.parse("2022-06-05T21:50:10Z"), "Olá mundo", "Estou muito feliz",us1);
		Post p2 =  new Post(null, Instant.parse("2022-06-05T23:50:10Z"), "#FORABOLSONARO", "Ladrão safado", us2);

		userRepository.saveAll(Arrays.asList(us1, us2));
		postRepository.saveAll(Arrays.asList(p1, p2));
	}

}
