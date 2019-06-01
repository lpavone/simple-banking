package com.worldnettps.simplebanking.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.UserSessionVO;
import com.worldnettps.simplebanking.service.UserService;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/{accountNumber}", produces = MediaType.APPLICATION_JSON)
	public UserSessionVO getAccounts(@PathVariable Long accountNumber){
		return userService.getUserByAccountNumber(accountNumber);
	}
	
}
