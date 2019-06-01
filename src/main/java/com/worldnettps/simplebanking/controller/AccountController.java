package com.worldnettps.simplebanking.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.AccountUserVO;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.service.AccountService;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public List<Account> getAccounts(){
		return accountService.getAccounts();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public Long createAccount(@RequestBody AccountUserVO accountUser){
		// TODO - validar campos obrigatórios
		
		// TODO - validar se ID's preenchidos (se sim, errado)
		
		return accountService.createAccount(accountUser);
	}

}
