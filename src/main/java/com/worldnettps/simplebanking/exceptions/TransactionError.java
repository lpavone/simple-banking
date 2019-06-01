package com.worldnettps.simplebanking.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransactionError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private Integer httpStatus;

}
