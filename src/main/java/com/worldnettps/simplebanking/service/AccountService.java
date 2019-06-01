package com.worldnettps.simplebanking.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worldnettps.simplebanking.dto.AccountUserDTO;
import com.worldnettps.simplebanking.dto.AccountDTO;
import com.worldnettps.simplebanking.exceptions.ObjectNotFoundException;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.Balance;
import com.worldnettps.simplebanking.model.User;
import com.worldnettps.simplebanking.repository.AccountRepository;
import com.worldnettps.simplebanking.util.MessageEnum;

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
	 * @param accountUser - {@link AccountUserDTO}
	 * @return account number - {@link Long}
	 */
	public Long createAccount(AccountUserDTO accountUser) {
		User user = getNewUser(accountUser);
		Balance actualBalance = getInitialBalance();

		Account account = Account.builder()
				.currency(accountUser.getCurrency())
				.user(user)
				.actualBalance(actualBalance)
				.build();
		
		return accountRepository.save(account).getNumber();
	}
	
	/**
	 * Get {@link AccountDTO} by account number
	 * @param accountNumber - {@link Long}
	 * @return {@link AccountDTO}
	 */
	public AccountDTO getAccountByAccountNumber(Long accountNumber) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		accountOptional.orElseThrow(() -> new ObjectNotFoundException(MessageEnum.ACCOUNT_NOT_FOUND));
		return new AccountDTO(accountOptional.get());
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
	 * @param accountUser - {@link AccountUserDTO}
	 * @return new user - {@link User}
	 */
	private User getNewUser(AccountUserDTO accountUser) {
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
