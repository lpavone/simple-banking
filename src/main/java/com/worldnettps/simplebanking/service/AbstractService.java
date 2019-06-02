package com.worldnettps.simplebanking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.worldnettps.simplebanking.exceptions.ObjectNotFoundException;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.User;
import com.worldnettps.simplebanking.repository.AccountRepository;
import com.worldnettps.simplebanking.repository.UserRepository;
import com.worldnettps.simplebanking.util.MessageEnum;

public class AbstractService {
	
	@Autowired
	protected AccountRepository accountRepository;

	@Autowired
	protected UserRepository userRepository;

	/**
	 * Get account by account number
	 * @param accountNumber - {@link Long}
	 * @return account - {@link Account}
	 */
	protected Account getAccountByAccountNumber(Long accountNumber) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		accountOptional.orElseThrow(() -> new ObjectNotFoundException(MessageEnum.ACCOUNT_NOT_FOUND));
		return accountOptional.get();
	}

	/**
	 * Get user by id
	 * @param idUser - {@link Long}
	 * @return user - {@link User}
	 */
	protected User getUserByIdUser(Long idUser) {
		Optional<User> userOptional = userRepository.findById(idUser);
		userOptional.orElseThrow(() -> new ObjectNotFoundException(MessageEnum.USER_NOT_FOUND));
		return userOptional.get();
	}
	
}
