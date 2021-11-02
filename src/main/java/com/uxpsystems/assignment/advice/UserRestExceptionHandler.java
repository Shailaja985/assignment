package com.uxpsystems.assignment.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.uxpsystems.assignment.exception.DuplicateUserException;
import com.uxpsystems.assignment.exception.EmptyInputException;
import com.uxpsystems.assignment.exception.NoUserRecordException;
import com.uxpsystems.assignment.exception.UserErrorResponse;
import com.uxpsystems.assignment.exception.UserNotFoundException;


@ControllerAdvice
public class UserRestExceptionHandler {
	
		//add an exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc){
			
			//create a error response
			UserErrorResponse error=new UserErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			//return response
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler
		public ResponseEntity<UserErrorResponse> handleException(EmptyInputException exc){
			
			//create a error response
			UserErrorResponse error=new UserErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			//return response
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler
		public ResponseEntity<UserErrorResponse> handleException(NoUserRecordException exc){
			
			//create a error response
			UserErrorResponse error=new UserErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			//return response
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler
		public ResponseEntity<UserErrorResponse> handleException(DuplicateUserException exc){
			
			//create a error response
			UserErrorResponse error=new UserErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			//return response
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler
		public ResponseEntity<UserErrorResponse> handleException(Exception exc){
			
			//create a error response
			UserErrorResponse error=new UserErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			//return response
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
		
}
