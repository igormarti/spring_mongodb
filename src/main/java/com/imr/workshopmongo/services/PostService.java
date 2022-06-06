package com.imr.workshopmongo.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imr.workshopmongo.dto.PostDTO;
import com.imr.workshopmongo.repositories.PostRepository;
import com.imr.workshopmongo.resources.utils.Url;
import com.imr.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public PostDTO findById(String id) {
		return new PostDTO(
				repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não encontrado")));
	}
	
	public List<PostDTO> findByTitle(String text){
		return repository.searchByTitle(text)
								.stream().map((p) -> new PostDTO(p)).collect(Collectors.toList());
	}

	public List<PostDTO> search(String min, String max, String text){
		
		Instant minDate = Url.convertDateParam(min+" 00:00:00", Instant.MIN);
		Instant maxDate = Url.convertDateParam(min+" 23:59:59", Instant.MAX);
		maxDate.plus(1, ChronoUnit.DAYS);
		
		return repository.search(minDate, maxDate, text)
								.stream().map((p) -> new PostDTO(p)).collect(Collectors.toList());
	}
}
