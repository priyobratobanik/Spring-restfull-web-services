package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
	public class GlobalExceptionHandler{

		@ExceptionHandler(EmployeeException.class)
		public ResponseEntity<MyCustomError> seedExceptionHandler(EmployeeException ee,WebRequest wrq){
			
			System.out.println("inside EmployeeException method...");
			MyCustomError seedError = new MyCustomError();
			seedError.setLdt(LocalDateTime.now());
			seedError.setMessage(ee.getMessage());
			seedError.setDetails(wrq.getDescription(false));
			
			return new ResponseEntity<>(seedError,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(TaskException.class)
		public ResponseEntity<MyCustomError> plantExceptionHandler(TaskException ee,WebRequest wrq){
			
			System.out.println("inside TaskException method...");
			MyCustomError plantError = new MyCustomError();
			plantError.setLdt(LocalDateTime.now());
			plantError.setMessage(ee.getMessage());
			plantError.setDetails(wrq.getDescription(false));
			
			return new ResponseEntity<>(plantError,HttpStatus.BAD_REQUEST);
		}
		
}
