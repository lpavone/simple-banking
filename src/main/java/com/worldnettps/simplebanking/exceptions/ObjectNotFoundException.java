package com.worldnettps.simplebanking.exceptions;

import com.worldnettps.simplebanking.util.MessageEnum;

/**
 * Exception that represents when a object wasn't found in database. 
 * @author Tiago
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor with message
	 * @param message - {@link String}
	 */
	public ObjectNotFoundException(MessageEnum message) {
		super(message.getMessage());
	}
	
	/**
	 * Construtor with message and cause
	 * @param message - {@link String}
	 * @param cause - {@link Throwable}
	 */
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
