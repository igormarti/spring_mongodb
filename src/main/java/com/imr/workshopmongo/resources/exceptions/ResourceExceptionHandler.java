package com.imr.workshopmongo.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.imr.workshopmongo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		Instant moment = Instant.now();
		int status = HttpStatus.NOT_FOUND.value();
		
		StandardError err = new StandardError(moment, status, "Não encontrado", e.getMessage(), 
				request.getRequestURL().toString());
		System.out.println(err);
		return ResponseEntity.status(status).body(err);
	}
	
}
