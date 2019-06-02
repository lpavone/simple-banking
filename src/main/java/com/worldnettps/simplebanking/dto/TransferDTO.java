package com.worldnettps.simplebanking.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransferDTO {

	private Long accountNumber;
	private Long idUser;
	
	private Date date;
	private BigDecimal amount;

	private Long accountNumberTo;

}
