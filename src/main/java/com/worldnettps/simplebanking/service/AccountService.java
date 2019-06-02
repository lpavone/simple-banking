package com.worldnettps.simplebanking.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worldnettps.simplebanking.dto.AccountDTO;
import com.worldnettps.simplebanking.dto.AccountUserDTO;
import com.worldnettps.simplebanking.dto.BalanceDTO;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.Balance;
import com.worldnettps.simplebanking.model.User;
import com.worldnettps.simplebanking.repository.BalanceRepository;

@Component
public class AccountService extends AbstractService {
	
	@Autowired
	private BalanceRepository balanceRepository;
	
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
		
		Long accountNumber = accountRepository.save(account).getNumber();
		
		actualBalance.setAccountNumber(accountNumber);
		balanceRepository.save(actualBalance);
		
		return accountNumber;
	}
	
	/**
	 * Get {@link AccountDTO} by account number
	 * @param accountNumber - {@link Long}
	 * @return {@link AccountDTO}
	 */
	public AccountDTO getAccountDTOByAccountNumber(Long accountNumber) {
		Account account = getAccountByAccountNumber(accountNumber);
		return new AccountDTO(account);
	}
	
	/**
	 * Get {@link BalanceDTO} by account number
	 * @param accountNumber - {@link Long}
	 * @return {@link BalanceDTO}
	 */
	public BalanceDTO getBalanceDTOByAccountNumber(Long accountNumber) {
		BigDecimal balanceAmount = balanceRepository.getBalanceByAccountNumber(accountNumber);
		return BalanceDTO.builder().amount(balanceAmount).build();
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
