package com.demo.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String> > handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> errorMap = new HashMap<>();
		List<FieldError> fieldErrorList = e.getFieldErrors();
		fieldErrorList.stream()
		.forEach(error->{String fieldName = error.getField();
						String message = error.getDefaultMessage();
						errorMap.put(fieldName, message);});
		
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
