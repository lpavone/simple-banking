package com.worldnettps.simplebanking.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.AccountUserDTO;
import com.worldnettps.simplebanking.dto.AccountDTO;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.service.AccountService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/account")
public class AccountController extends AbstractController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Account>> getAccounts(){
		List<Account> accounts = accountService.getAccounts();
		return body(accounts);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON, path="/{accountNumber}")
	public ResponseEntity<AccountDTO> getAccounts(@PathVariable Long accountNumber){
		// TODO - validar campos obrigatórios
		
		AccountDTO account = accountService.getAccountByAccountNumber(accountNumber);
		return body(account);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Long> createAccount(@RequestBody AccountUserDTO accountUser){
		// TODO - validar campos obrigatórios
		
		// TODO - validar se ID's preenchidos (se sim, errado)
		
		Long account = accountService.createAccount(accountUser);
		return body(account);
	}

}
