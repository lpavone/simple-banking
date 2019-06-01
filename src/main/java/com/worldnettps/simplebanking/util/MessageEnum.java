package com.worldnettps.simplebanking.util;

public enum MessageEnum {
	
	ACCOUNT_NOT_FOUND("Account not found."),
	USER_NOT_FOUND("User not found.");
	
	private String message;
	
	private MessageEnum(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.message;
	}
}
