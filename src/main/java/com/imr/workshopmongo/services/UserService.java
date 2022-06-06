package com.imr.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imr.workshopmongo.domain.User;
import com.imr.workshopmongo.dto.UserDTO;
import com.imr.workshopmongo.dto.UserPostDTO;
import com.imr.workshopmongo.repositories.UserRepository;
import com.imr.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		return repository.findAll().stream().map((u) -> new UserDTO(u)).collect(Collectors.toList());
	}

	public UserDTO findById(String id) {

		return new UserDTO(
				repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado")));
	}

	public UserDTO insert(User userObj) {
		return new UserDTO(repository.insert(userObj));
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public UserDTO update(User userObj) {
		User newObj = repository.findById(userObj.getId())
						.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));

		updateData(newObj, userObj);
		repository.save(newObj);

		return new UserDTO(newObj);
	}
	
	public UserPostDTO findPostsByUser(String id){
		return new UserPostDTO(
				repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado")));
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getName(), userDTO.getEmail());
	}

	private void updateData(User newObj, User userObj) {
		newObj.setName(userObj.getName());
		newObj.setEmail(userObj.getEmail());
	}
}
