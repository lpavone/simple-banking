package com.worldnettps.simplebanking.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.UserSessionDTO;
import com.worldnettps.simplebanking.service.UserService;
import com.worldnettps.simplebanking.util.SimpleBankingUtil;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/login")
public class LoginController extends AbstractController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/{accountNumber}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<UserSessionDTO> getAccounts(@PathVariable Long accountNumber){		
		SimpleBankingUtil.validateData(accountNumber, "Account number");

		UserSessionDTO userSessionVO = userService.getUserByAccountNumber(accountNumber);
		return body(userSessionVO);
	}
	
}
