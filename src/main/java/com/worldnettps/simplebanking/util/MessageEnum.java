package com.worldnettps.simplebanking.util;

public enum MessageEnum {
	
	ACCOUNT_ORIGIN_DESTINATION_EQUALS("The destination account cannot be your own account."),
	AMOUNT_INVALID("The amount need be a positive value."),
	INSUFFICIENT_BALANCE("Insufficient balance."),
	INVALID_SAVE_USER("The account cannot be save."),
	ACCOUNT_NOT_FOUND("Account not found."),
	USER_NOT_FOUND("User not found."),
	INVALID_DATA("Invalid data.");
	
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
