package com.worldnettps.simplebanking.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.AccountUserDTO;
import com.worldnettps.simplebanking.dto.UserSessionDTO;
import com.worldnettps.simplebanking.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController extends AbstractController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/{idUser}/{accountNumber}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<AccountUserDTO> getUserById(
			@PathVariable("idUser") Long idUser, 
			@PathVariable("accountNumber") Long accountNumber){
		
		// TODO - validar campos obrigatorios
		
		AccountUserDTO accountUserVO = userService.findById(idUser, accountNumber);
		return body(accountUserVO);
	}
	
	@PutMapping(path="/{idUser}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<UserSessionDTO> updateUserProfile(@PathVariable Long idUser, 
			@RequestBody AccountUserDTO accountUser){
		
		// TODO - validar campos obrigatorios
		
		UserSessionDTO account = userService.updateAccount(accountUser);
		return body(account);
	}


}
