package com.bank.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExcetion {

	@ExceptionHandler(value=UserException.class)
	public ResponseEntity<String> handleIllegalArgumentException(UserException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errormap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		
			errormap.put(error.getField(), error.getDefaultMessage())
		);
		
		return new ResponseEntity<>(errormap,HttpStatus.BAD_REQUEST);
	}
}
