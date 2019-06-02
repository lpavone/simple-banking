package com.worldnettps.simplebanking.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.AccountDTO;
import com.worldnettps.simplebanking.dto.AccountUserDTO;
import com.worldnettps.simplebanking.dto.BalanceDTO;
import com.worldnettps.simplebanking.dto.UserSessionDTO;
import com.worldnettps.simplebanking.service.AccountService;
import com.worldnettps.simplebanking.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/account")
public class AccountController extends AbstractController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	// TODO - juntar este metodo com o anterior
	@GetMapping(path="/{accountNumber}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<AccountDTO> getAccounts(@PathVariable Long accountNumber){
		// TODO - validar campos obrigatórios
		
		AccountDTO account = accountService.getAccountDTOByAccountNumber(accountNumber);
		return body(account);
	}
	
	@GetMapping(path="/{accountNumber}/balance", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<BalanceDTO> getBalanceAccount(@PathVariable Long accountNumber){
		// TODO - validar campos obrigatórios
		
		BalanceDTO balance = accountService.getBalanceDTOByAccountNumber(accountNumber);
		return body(balance);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Long> createAccount(@RequestBody AccountUserDTO accountUser){
		// TODO - validar campos obrigatórios
		
		// TODO - validar se ID's preenchidos (se sim, errado)
		
		Long account = accountService.createAccount(accountUser);
		return body(account);
	}
	
	@GetMapping(path="/user/{idUser}/{accountNumber}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<AccountUserDTO> getUserById(
			@PathVariable("idUser") Long idUser, 
			@PathVariable("accountNumber") Long accountNumber){
		
		// TODO - validar campos obrigatorios
		
		AccountUserDTO accountUserVO = userService.findById(idUser, accountNumber);
		return body(accountUserVO);
	}
	
	@PutMapping(path="/user/{idUser}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<UserSessionDTO> updateUserProfile(
			@PathVariable Long idUser, 
			@RequestBody AccountUserDTO accountUser){
		
		// TODO - validar campos obrigatorios
		
		UserSessionDTO account = userService.updateAccount(accountUser);
		return body(account);
	}

}
