package com.imr.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imr.workshopmongo.domain.User;
import com.imr.workshopmongo.dto.UserDTO;
import com.imr.workshopmongo.repositories.UserRepository;
import com.imr.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	
	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll(){
		return repository.findAll().stream()
				.map((u) -> new UserDTO(u)).collect(Collectors.toList());
	}
	
	public UserDTO findById(String id) {
		
		return new UserDTO(
				repository.findById(id)
					.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"))
			) ;
	}
	
	public User insert(User userObj) {
		return repository.insert(userObj);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getName(), userDTO.getEmail());
	}
}
