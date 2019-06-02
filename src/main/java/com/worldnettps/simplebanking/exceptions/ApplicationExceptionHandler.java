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
	 * Handle the {@link TransactionError}
	 * @param exception - {@link ObjectNotFoundException}
	 * @param request - {@link HttpServletRequest}
	 * @return response with error
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<TransactionError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		return createHttpError(exception, httpStatus);
	}
	
	/**
	 * Handle the {@link TransactionError}
	 * @param exception - {@link UnauthorizedAcessException}
	 * @param request - {@link HttpServletRequest}
	 * @return response with error
	 */
	@ExceptionHandler(UnauthorizedAcessException.class)
	public ResponseEntity<TransactionError> unauthorizedException(UnauthorizedAcessException exception, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
		return createHttpError(exception, httpStatus);
	}
	
	/**
	 * Handle the {@link TransactionError}
	 * @param exception - {@link RuntimeException}
	 * @param request - {@link HttpServletRequest}
	 * @return response with error
	 */
	@ExceptionHandler(value = {BusinessException.class, InvalidDataException.class})
	public ResponseEntity<TransactionError> badRequestException(RuntimeException exception, HttpServletRequest request) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return createHttpError(exception, httpStatus);
	}

	/**
	 * Create the http error
	 * @param exception - {@link RuntimeException}
	 * @param httpStatus - {@link HttpStatus}
	 * @return {@link ResponseEntity} with custom status and message
	 */
	private ResponseEntity<TransactionError> createHttpError(RuntimeException exception, HttpStatus httpStatus) {
		TransactionError error = new TransactionError(exception.getMessage(), httpStatus.value());
		return ResponseEntity.status(httpStatus).body(error);
	}

}
