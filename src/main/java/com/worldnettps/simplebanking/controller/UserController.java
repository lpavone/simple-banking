package com.worldnettps.simplebanking.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.AccountUserVO;
import com.worldnettps.simplebanking.dto.UserSessionVO;
import com.worldnettps.simplebanking.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/{idUser}/{accountNumber}", produces = MediaType.APPLICATION_JSON)
	public AccountUserVO getUserById(
			@PathVariable("idUser") Long idUser, 
			@PathVariable("accountNumber") Long accountNumber){
		
		// TODO - validar campos obrigatorios
		
		return userService.findById(idUser, accountNumber);
	}
	
	@PutMapping(path="/{idUser}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public UserSessionVO updateUserProfile(@PathVariable Long idUser, 
			@RequestBody AccountUserVO accountUser){
		
		// TODO - validar campos obrigatorios
		
		return userService.updateAccount(accountUser);
	}


}
