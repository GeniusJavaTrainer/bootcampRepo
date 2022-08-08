package com.employee.exception;

public class EmployerAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 225636108272454893L;

	public EmployerAlreadyExistException(String message) {
		super(message);
	}
}
