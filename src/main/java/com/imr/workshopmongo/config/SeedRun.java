package com.imr.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.imr.workshopmongo.domain.Post;
import com.imr.workshopmongo.domain.User;
import com.imr.workshopmongo.dto.AuthorDTO;
import com.imr.workshopmongo.dto.CommentDTO;
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
		userRepository.saveAll(Arrays.asList(us1, us2));

		Post p1 = new Post(null, Instant.parse("2022-06-05T21:50:10Z"), "Olá mundo", "Estou muito feliz",
				new AuthorDTO(us1));
		Post p2 = new Post(null, Instant.parse("2022-06-05T23:50:10Z"), "#FORABOLSONARO", "Ladrão safado",
				new AuthorDTO(us2));
		
		CommentDTO c1 = new CommentDTO("que bom <3!!!","2022-06-06T10:00:00Z", new AuthorDTO(us2));
		CommentDTO c2 = new CommentDTO("Presidente lixo!!!","2022-06-06T11:00:00Z", new AuthorDTO(us1));
		
		p1.getComments().add(c1);
		p2.getComments().add(c2);
		
		postRepository.saveAll(Arrays.asList(p1, p2));

		us1.getPosts().add(p1);
		us2.getPosts().add(p2);
		userRepository.saveAll(Arrays.asList(us1, us2));
	}

}
