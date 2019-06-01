package com.worldnettps.simplebanking.controller;

import org.springframework.http.ResponseEntity;

public abstract class AbstractController {
	
	protected <T> ResponseEntity<T> body(T value) {
		return ResponseEntity.ok().body(value);
	}

}
