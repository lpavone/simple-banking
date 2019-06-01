package com.worldnettps.simplebanking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worldnettps.simplebanking.dto.AccountUserVO;
import com.worldnettps.simplebanking.dto.UserSessionVO;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.User;
import com.worldnettps.simplebanking.repository.AccountRepository;
import com.worldnettps.simplebanking.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;
	
	/**
	 * Update the user profile data
	 * @param accountUser - {@link AccountUserVO}
	 * @return updated user - {@link UserSessionVO}
	 */
	public UserSessionVO updateAccount(AccountUserVO accountUser) {
		Optional<User> userOptional = userRepository.findById(accountUser.getIdUser());
		Optional<Account> accountOptional = accountRepository.findById(accountUser.getAccountNumber());
		
		if (userOptional.isPresent() && accountOptional.isPresent()){
			User user = userOptional.get();
			Account account = accountOptional.get();
			
			user.setAddress(accountUser.getAddress());
			user.setDocumentID(accountUser.getDocumentID());
			user.setEmail(accountUser.getEmail());
			user.setName(accountUser.getName());
			user.setPhoneNumber(accountUser.getPhoneNumber());
			
			user = userRepository.save(user);
			
			return createUserSession(user, account);
		}
		
		// TODO - lançar exceção
		return null;
	}

	/**
	 * Get the login user data, by account number
	 * @param accountNumber - {@link Long}
	 * @return user data - {@link UserSessionVO}
	 */
	public UserSessionVO getUserByAccountNumber(Long accountNumber) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		if (accountOptional.isPresent()){
			Account account = accountOptional.get();
			
			return createUserSession(account.getUser(), account);
		}
		
		// TODO - lançar exceção
		return null;
	}

	public AccountUserVO findById(Long idUser, Long accountNumber) {
		Optional<User> userOptional = userRepository.findById(idUser);
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		
		if (userOptional.isPresent() && accountOptional.isPresent()){
			User user = userOptional.get();
			Account account = accountOptional.get();
			
			return createAccountUserVO(user, account);
		}
		
		// TODO - lançar exceção
		return null;	
	}

	/**
	 * Create an object contained the user/account datas, to show in view
	 * @param user
	 * @param account
	 * @return
	 */
	private AccountUserVO createAccountUserVO(User user, Account account) {
		return AccountUserVO.builder()
				.accountNumber(account.getNumber())
				.address(user.getAddress())
				.currency(account.getCurrency())
				.documentID(user.getDocumentID())
				.email(user.getEmail())
				.idUser(user.getId())
				.name(user.getName())
				.phoneNumber(user.getPhoneNumber())
				.build();
	}

	/**
	 * Create an object contained the user data, to show in view
	 * @param user - {@link User}
	 * @param account -  {@link Account}
	 * @return user data - {@link UserSessionVO}
	 */
	private UserSessionVO createUserSession(User user, Account account) {
		UserSessionVO userSession = UserSessionVO.builder()
				.idUser(user.getId())
				.accountNumber(account.getNumber())
				.currency(account.getCurrency())
				.name(user.getName())
				.build();
		
		return userSession;
	}
	
	
}
