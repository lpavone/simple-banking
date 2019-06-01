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
public class AccountUserDTO {

	private Long accountNumber;
	private Long idUser;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private String documentID;
	private CurrencyType currency;

	/**
	 * Default constructor
	 * @param user
	 * @param account
	 */
	public AccountUserDTO(User user, Account account) {
		this.accountNumber = account.getNumber();
		this.address = user.getAddress();
		this.currency = account.getCurrency();
		this.documentID = user.getDocumentID();
		this.email = user.getEmail();
		this.idUser = user.getId();
		this.name = user.getName();
		this.phoneNumber = user.getPhoneNumber();
	}
	
}
