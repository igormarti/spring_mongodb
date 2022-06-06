package com.imr.workshopmongo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.imr.workshopmongo.domain.Post;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String PATTERN_FORMAT_DATE = "yyyy-MM-dd HH:mm";
	
	private String id;
	private String date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	public PostDTO() {
	}
	
	public PostDTO(Post obj) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT_DATE).withZone(ZoneId.of("GMT"));
		
		this.id = obj.getId();
		this.date = formatter.format(obj.getDate());
		this.title = obj.getTitle();
		this.body = obj.getBody();
		this.author = obj.getAuthor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(Instant date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT_DATE).withZone(ZoneId.of("GMT"));
		this.date = formatter.format(date);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
