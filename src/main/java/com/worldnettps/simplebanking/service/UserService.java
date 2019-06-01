package com.worldnettps.simplebanking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worldnettps.simplebanking.dto.AccountUserDTO;
import com.worldnettps.simplebanking.dto.UserSessionDTO;
import com.worldnettps.simplebanking.exceptions.ObjectNotFoundException;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.User;
import com.worldnettps.simplebanking.repository.AccountRepository;
import com.worldnettps.simplebanking.repository.UserRepository;
import com.worldnettps.simplebanking.util.MessageEnum;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * Update the user profile data
	 * @param accountUser - {@link AccountUserDTO}
	 * @return updated user - {@link UserSessionDTO}
	 */
	public UserSessionDTO updateAccount(AccountUserDTO accountUser) {
		Optional<User> userOptional = userRepository.findById(accountUser.getIdUser());
		Optional<Account> accountOptional = accountRepository.findById(accountUser.getAccountNumber());
		
		accountOptional.orElseThrow(() -> new ObjectNotFoundException(MessageEnum.ACCOUNT_NOT_FOUND));
		userOptional.orElseThrow(() -> new ObjectNotFoundException(MessageEnum.USER_NOT_FOUND));

		User user = userOptional.get();
		Account account = accountOptional.get();
		
		user = updateUser(accountUser, user);
		
		return new UserSessionDTO(user, account);
	}


	/**
	 * Get the login user data, by account number
	 * @param accountNumber - {@link Long}
	 * @return user data - {@link UserSessionDTO}
	 */
	public UserSessionDTO getUserByAccountNumber(Long accountNumber) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);

		accountOptional.orElseThrow(() -> new ObjectNotFoundException(MessageEnum.ACCOUNT_NOT_FOUND));

		Account account = accountOptional.get();
		return new UserSessionDTO(account);
	}

	/**
	 * Get account/user informations by idUser and accountNumber
	 * @param idUser - {@link Long}
	 * @param accountNumber - {@link Long}
	 * @return {@link AccountUserDTO}
	 */
	public AccountUserDTO findById(Long idUser, Long accountNumber) {
		Optional<User> userOptional = userRepository.findById(idUser);
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		
		accountOptional.orElseThrow(() -> new ObjectNotFoundException(MessageEnum.ACCOUNT_NOT_FOUND));
		userOptional.orElseThrow(() -> new ObjectNotFoundException(MessageEnum.USER_NOT_FOUND));

		User user = userOptional.get();
		Account account = accountOptional.get();
		
		return new AccountUserDTO(user, account);
	}

	/**
	 * Update the user object with the received data
	 * @param accountUser - {@link AccountUserDTO}
	 * @param user - {@link User}
	 * @return user updated - {@link User}
	 */
	private User updateUser(AccountUserDTO accountUser, User user) {
		user.setAddress(accountUser.getAddress());
		user.setDocumentID(accountUser.getDocumentID());
		user.setEmail(accountUser.getEmail());
		user.setName(accountUser.getName());
		user.setPhoneNumber(accountUser.getPhoneNumber());
		
		user = userRepository.save(user);
		return user;
	}

}
