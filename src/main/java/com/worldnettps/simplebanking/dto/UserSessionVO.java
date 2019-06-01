package com.worldnettps.simplebanking.dto;

import com.worldnettps.simplebanking.model.enums.CurrencyType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserSessionVO {

	private Long idUser;
	private String name;
	private Long accountNumber;
	private CurrencyType currency;
	
}
