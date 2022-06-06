package com.imr.workshopmongo.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Instant date;
	private String text;
	private String body;
	private AuthorDTO author;
	
	public CommentDTO() {
	}
	
	public CommentDTO(String text, String date, AuthorDTO obj) {
		this.text = text;
		this.date = Instant.parse(date);
		this.author = obj;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	
}
