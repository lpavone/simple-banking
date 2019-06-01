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
public class UserSessionDTO {

	private Long idUser;
	private String name;
	private Long accountNumber;
	private CurrencyType currency;

	/**
	 * Construtor using account data
	 * @param account - {@link Account}
	 */
	public UserSessionDTO(Account account) {
		this(account.getUser(), account);
	}
	
	/**
	 * Construtor using User and account data
	 * @param user - {@link User}
	 * @param account - {@link Account}
	 */
	public UserSessionDTO(User user, Account account) {
		this.idUser = user.getId();
		this.accountNumber = account.getNumber();
		this.currency = account.getCurrency();
		this.name = user.getName();
	}
}
