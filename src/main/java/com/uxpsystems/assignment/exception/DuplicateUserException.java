package com.uxpsystems.assignment.exception;

@SuppressWarnings("serial")
public class DuplicateUserException extends RuntimeException{

	public DuplicateUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateUserException(String message) {
		super(message);
	}

	public DuplicateUserException(Throwable cause) {
		super(cause);
	}
}
