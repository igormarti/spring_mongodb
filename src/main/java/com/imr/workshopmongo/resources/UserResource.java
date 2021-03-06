package com.imr.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imr.workshopmongo.domain.Post;
import com.imr.workshopmongo.domain.User;
import com.imr.workshopmongo.dto.UserDTO;
import com.imr.workshopmongo.dto.UserPostDTO;
import com.imr.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<UserDTO> users = userService.findAll();

		return ResponseEntity.ok(users);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {

		UserDTO user = userService.findById(id);

		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<User> store(@RequestBody UserDTO dto) {

		User user = userService.fromDTO(dto);
		userService.insert(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).body(user);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {

		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@RequestBody UserDTO dto, @PathVariable String id) {

		User user = userService.fromDTO(dto);
		user.setId(id);
		userService.update(user);

		return ResponseEntity.ok().body(user);
	}

	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPostsByUser(@PathVariable String id) {

		UserPostDTO user = userService.findPostsByUser(id);

		return ResponseEntity.ok(user.getPosts());
	}
}
