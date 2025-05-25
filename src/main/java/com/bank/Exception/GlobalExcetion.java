package com.bank.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class GlobalExcetion {

	@ExceptionHandler(value=UserException.class)
	public ResponseEntity<String> handleIllegalArgumentException(UserException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=AccountExce.class)
	public ResponseEntity<String> handleIllegalArgumentException(AccountExce acc)
	{
		return new ResponseEntity<String>(acc.getMessage(),HttpStatus.NOT_FOUND);
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
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleValidationErrors(ConstraintViolationException ex) {
	    List<String> errors = ex.getConstraintViolations()
	                            .stream()
	                            .map(ConstraintViolation::getMessage)
	                            .collect(Collectors.toList());
	    return ResponseEntity.badRequest().body(errors);
	}
}
