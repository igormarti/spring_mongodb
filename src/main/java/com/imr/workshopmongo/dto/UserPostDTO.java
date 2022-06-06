package com.imr.workshopmongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.imr.workshopmongo.domain.Post;
import com.imr.workshopmongo.domain.User;

public class UserPostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private List<Post> posts = new ArrayList<>();
	
	public UserPostDTO() {
	}
	
	public UserPostDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		posts = obj.getPosts();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

}
