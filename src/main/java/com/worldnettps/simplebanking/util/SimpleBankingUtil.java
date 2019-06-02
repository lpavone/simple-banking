package com.worldnettps.simplebanking.util;

import org.springframework.util.ObjectUtils;

import com.worldnettps.simplebanking.exceptions.InvalidDataException;
import com.worldnettps.simplebanking.exceptions.UnauthorizedAcessException;

public final class SimpleBankingUtil {
	
	/**
	 * Validade if value is valid
	 * @param value
	 */
	public static void validateUser(Object value) {
		if (ObjectUtils.isEmpty(value)){
			throw new UnauthorizedAcessException(MessageEnum.USER_NOT_FOUND);
		}
	}
	
	/**
	 * Validade if value is valid
	 * @param value
	 */
	public static void validateData(Object value) {
		if (ObjectUtils.isEmpty(value)){
			throw new InvalidDataException(MessageEnum.INVALID_DATA);
		}
	}
	
	/**
	 * Validade if value is valid
	 * @param value
	 */
	public static void validateData(Object value, String fieldName) {
		if (ObjectUtils.isEmpty(value)){
			throw new InvalidDataException(MessageEnum.INVALID_DATA, fieldName);
		}
	}

}
