package com.restapi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = MethodArgumentNotValidException.class)   //this annotation is used to cover only for this method exception
	public ResponseEntity<Object> methodArgException(MethodArgumentNotValidException exc) {
		
		Map<String, String> errorMap = new HashMap<>();
		exc.getFieldErrors().stream().forEach(error-> errorMap.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}
	
	@ExceptionHandler(value = DataNotFoundException.class)   
	public ResponseEntity<Object> dataNotFoundException(DataNotFoundException ex) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
}
