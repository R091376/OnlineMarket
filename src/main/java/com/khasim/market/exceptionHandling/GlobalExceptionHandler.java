package com.khasim.market.exceptionHandling;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.khasim.market.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
		System.out.println(ex.getBindingResult().getAllErrors());
		System.out.println(ex.getBindingResult().getFieldErrors());
		
		List<String> errors = ex.getBindingResult().getAllErrors()
                .stream().map(fe ->fe.getDefaultMessage()).collect(Collectors.toList());
		System.out.println("printing errors");
		System.out.println(errors);
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, List<String>>> handleNotFoundException(ResourceNotFoundException ex) {
	    List<String> errors = Collections.singletonList(ex.getMessage());
	    return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Map<String, List<String>>> handleGeneralExceptions(Exception ex) {
	    List<String> errors = Collections.singletonList(ex.getMessage());
	    return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
