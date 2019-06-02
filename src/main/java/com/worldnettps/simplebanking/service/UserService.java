package com.worldnettps.simplebanking.service;

import org.springframework.stereotype.Component;

import com.worldnettps.simplebanking.dto.AccountUserDTO;
import com.worldnettps.simplebanking.dto.UserSessionDTO;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.User;

@Component
public class UserService extends AbstractService {
	
	/**
	 * Update the user profile data
	 * @param accountUser - {@link AccountUserDTO}
	 * @return updated user - {@link UserSessionDTO}
	 */
	public UserSessionDTO updateAccount(AccountUserDTO accountUser) {
		User user = getUserByIdUser(accountUser.getIdUser());
		Account account = getAccountByAccountNumber(accountUser.getAccountNumber());
		
		user = updateUser(accountUser, user);
		
		return new UserSessionDTO(user, account);
	}


	/**
	 * Get the login user data, by account number
	 * @param accountNumber - {@link Long}
	 * @return user data - {@link UserSessionDTO}
	 */
	public UserSessionDTO getUserByAccountNumber(Long accountNumber) {
		Account account = getAccountByAccountNumber(accountNumber);
		return new UserSessionDTO(account);
	}

	/**
	 * Get account/user informations by idUser and accountNumber
	 * @param idUser - {@link Long}
	 * @param accountNumber - {@link Long}
	 * @return {@link AccountUserDTO}
	 */
	public AccountUserDTO findById(Long idUser, Long accountNumber) {
		User user = getUserByIdUser(idUser);
		Account account = getAccountByAccountNumber(accountNumber);
		
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
