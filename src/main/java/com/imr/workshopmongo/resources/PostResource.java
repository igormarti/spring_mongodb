package com.imr.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imr.workshopmongo.dto.PostDTO;
import com.imr.workshopmongo.resources.utils.Url;
import com.imr.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {

		PostDTO post = postService.findById(id);

		return ResponseEntity.ok(post);
	}
	
	@GetMapping(value = "/searchTitle")
	public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "title", defaultValue = "") String text) {

		List<PostDTO> posts = postService.findByTitle(Url.decodeParam(text));

		return ResponseEntity.ok(posts);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<List<PostDTO>> search(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate
	)
	{

		List<PostDTO> posts = postService.search(minDate, maxDate, text);

		return ResponseEntity.ok(posts);
	}
}
