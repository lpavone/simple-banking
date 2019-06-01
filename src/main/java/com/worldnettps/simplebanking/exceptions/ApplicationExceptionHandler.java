package com.worldnettps.simplebanking.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class responsible for catching exceptions returning a error default type.
 * @author Tiago
 */
@ControllerAdvice
public class ApplicationExceptionHandler {
	
	/**
	 * Handle the {@link ObjectNotFoundException}
	 * @param exception - {@link ObjectNotFoundException}
	 * @param request - {@link HttpServletRequest}
	 * @return response with error
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<TransactionError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		TransactionError error = new TransactionError(exception.getMessage(), httpStatus.value());
		return ResponseEntity.status(httpStatus).body(error);
	}

}
