package com.worldnettps.simplebanking.dto;

import com.worldnettps.simplebanking.model.enums.CurrencyType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountUserVO {

	private Long accountNumber;
	private Long idUser;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private String documentID;
	private CurrencyType currency;
	
}
