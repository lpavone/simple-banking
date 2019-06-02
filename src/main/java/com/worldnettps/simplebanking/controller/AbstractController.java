package com.worldnettps.simplebanking.controller;

import org.springframework.http.ResponseEntity;

/**
 * Abstract class for rest controller
 * @author Tiago
 */
public abstract class AbstractController {

	/**
	 * Fill the body to response entity
	 * @param value
	 * @return {@link ResponseEntity}
	 */
	protected <T> ResponseEntity<T> body(T value) {
		return ResponseEntity.ok().body(value);
	}

}
