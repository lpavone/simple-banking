package com.worldnettps.simplebanking.controller.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.AccountUserVO;
import com.worldnettps.simplebanking.model.enums.CurrencyType;
import com.worldnettps.simplebanking.service.AccountService;

@RestController
@RequestMapping("/api/v1/mock")
public class MockController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public boolean init(){
		
		createUserTest1();
		
		createUserTest2();
		
		return true;
	}

	private void createUserTest1() {
		accountService.createAccount(AccountUserVO.builder()
				.address("QC 3 C 3")
				.currency(CurrencyType.BRL)
				.documentID("2115242")
				.email("tiagodf.souza@gmail.com")
				.name("Tiago Souza")
				.phoneNumber("(61) 99209-8528")
				.build());
	}

	private void createUserTest2() {
		accountService.createAccount(AccountUserVO.builder()
				.address("Casa XPTO rua 30")
				.currency(CurrencyType.BRL)
				.documentID("321321-XXX")
				.email("fulana@tal.com")
				.name("Fulana de Tal")
				.phoneNumber("(61) 999999-1111")
				.build());		
	}
	
}
