package com.employee.exception;

public class DuplicateUserNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3091882195474409540L;

	public DuplicateUserNameException() {
		super();
	}

	public DuplicateUserNameException(String message) {
		super(message);
	}	
}