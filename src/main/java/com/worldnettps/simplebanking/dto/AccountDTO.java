package com.worldnettps.simplebanking.dto;

import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.User;
import com.worldnettps.simplebanking.model.enums.CurrencyType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDTO {

	private Long accountNumber;
	private CurrencyType currency;

	private Long idUser;
	private String name;
	private String email;
	
	
	/**
	 * Default constructor, using account data
	 * @param account
	 */
	public AccountDTO(Account account) {
		User user = account.getUser();
		
		this.accountNumber = account.getNumber();
		this.currency = account.getCurrency();
		this.idUser = user.getId();
		this.name = user.getName();
		this.email = user.getName();
	}
	
}
