package com.imr.workshopmongo.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;


public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Instant moment;
	private int status;
	private String message;
	private String error;
	private String path;
	
	public StandardError() {
		super();
	}

	public StandardError(Instant moment, int status, String message, String error, String path) {
		super();
		this.moment = moment;
		this.status = status;
		this.message = message;
		this.error = error;
		this.path = path;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "StandardError [moment=" + moment + ", status=" + status + ", message=" + message + ", error=" + error
				+ ", path=" + path + "]";
	}
	
}
