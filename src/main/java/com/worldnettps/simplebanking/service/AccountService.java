package com.worldnettps.simplebanking.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worldnettps.simplebanking.dto.AccountUserVO;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.Balance;
import com.worldnettps.simplebanking.model.User;
import com.worldnettps.simplebanking.repository.AccountRepository;

@Component
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * Get all accounts
	 * @return {@link List} of {@link Account}
	 */
	public List<Account> getAccounts(){
		List<Account> accounts = new ArrayList<>();
		accountRepository.findAll().forEach(account -> accounts.add(account));
		return accounts;
	}

	/**
	 * Create a new account and user
	 * @param accountUser - {@link AccountUserVO}
	 * @return account number - {@link Long}
	 */
	public Long createAccount(AccountUserVO accountUser) {
		Account account = getNewAccout(accountUser);

		return accountRepository.save(account).getNumber();
	}

	/**
	 * Get new user account
	 * @param accountUser - {@link AccountUserVO}
	 * @return new account {@link Account}
	 */
	private Account getNewAccout(AccountUserVO accountUser) {
		User user = getNewUser(accountUser);
		Balance actualBalance = getInitialBalance();

		Account account = Account.builder()
				.currency(accountUser.getCurrency())
				.user(user)
				.actualBalance(actualBalance)
				.build();
		return account;
	}

	/**
	 * Create the initial balance for account
	 * @return inicial balance - {@link Balance}
	 */
	private Balance getInitialBalance() {
		Balance actualBalance = Balance.builder()
				.inicialBalance(BigDecimal.ZERO)
				.finalBalance(BigDecimal.ZERO)
				.build();
		return actualBalance;
	}

	/**
	 * Create the new user for account
	 * @param accountUser - {@link AccountUserVO}
	 * @return new user - {@link User}
	 */
	private User getNewUser(AccountUserVO accountUser) {
		User user = User.builder()
				.address(accountUser.getAddress())
				.documentID(accountUser.getDocumentID())
				.email(accountUser.getEmail())
				.name(accountUser.getName())
				.phoneNumber(accountUser.getPhoneNumber())
				.build();
		return user;
	}

}
