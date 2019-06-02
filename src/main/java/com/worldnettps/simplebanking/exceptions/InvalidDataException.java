package com.worldnettps.simplebanking.exceptions;

import com.worldnettps.simplebanking.util.MessageEnum;

/**
 * Exception that represents filled invalid data (null or invalid)
 * @author Tiago
 */
public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor with message
	 * @param message - {@link MessageEnum}
	 */
	public InvalidDataException(MessageEnum message) {
		super(message.getMessage());
	}
	
	/**
	 * Construtor with message and field name
	 * @param message - {@link MessageEnum}
	 * @param fieldName - {@link String}
	 */
	public InvalidDataException(MessageEnum message, String fieldName) {
		super(fieldName + ": " + message.getMessage());
	}
	
	/**
	 * Construtor with message and cause
	 * @param message - {@link String}
	 * @param cause - {@link Throwable}
	 */
	public InvalidDataException(String message, Throwable cause) {
		super(message, cause);
	}

}
