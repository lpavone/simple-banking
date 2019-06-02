package com.worldnettps.simplebanking.exceptions;

import com.worldnettps.simplebanking.util.MessageEnum;

/**
 * Exception that represents a business exception
 * @author Tiago
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor with message
	 * @param message - {@link MessageEnum}
	 */
	public BusinessException(MessageEnum message) {
		super(message.getMessage());
	}
	
	/**
	 * Construtor with message and cause
	 * @param message - {@link String}
	 * @param cause - {@link Throwable}
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

}
