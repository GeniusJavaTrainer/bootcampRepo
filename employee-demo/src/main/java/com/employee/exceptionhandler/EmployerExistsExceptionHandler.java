package com.employee.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.exception.EmployerAlreadyExistException;
@ControllerAdvice
public class EmployerExistsExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value 
		      = { EmployerAlreadyExistException.class, EmployeeNotFoundException.class})
		    protected ResponseEntity<Object> handleConflict(
		      RuntimeException ex, WebRequest request) {
		        String bodyOfResponse = "An error occured: "+ex.getMessage();
		        return handleExceptionInternal(ex, bodyOfResponse, 
		          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		    }
}