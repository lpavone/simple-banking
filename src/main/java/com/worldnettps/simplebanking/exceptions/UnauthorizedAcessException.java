package com.worldnettps.simplebanking.exceptions;

import com.worldnettps.simplebanking.util.MessageEnum;

/**
 * Exception that represents filled invalid data (null or invalid)
 * @author Tiago
 */
public class UnauthorizedAcessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor with message
	 * @param message - {@link String}
	 */
	public UnauthorizedAcessException(MessageEnum message) {
		super(message.getMessage());
	}
	
	/**
	 * Construtor with message and cause
	 * @param message - {@link String}
	 * @param cause - {@link Throwable}
	 */
	public UnauthorizedAcessException(String message, Throwable cause) {
		super(message, cause);
	}

}
