package com.worldnettps.simplebanking.controller.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worldnettps.simplebanking.dto.AccountUserDTO;
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
		AccountUserDTO accountUserVO = new AccountUserDTO();

		accountUserVO.setAddress("QC 3 C 3");
		accountUserVO.setCurrency(CurrencyType.BRL);
		accountUserVO.setDocumentID("2115242");
		accountUserVO.setEmail("tiagodf.souza@gmail.com");
		accountUserVO.setName("Tiago Souza");
		accountUserVO.setPhoneNumber("(61) 99209-8528");

		accountService.createAccount(accountUserVO);
	}

	private void createUserTest2() {
		AccountUserDTO accountUserVO = new AccountUserDTO();

		accountUserVO.setAddress("Casa XPTO rua 30");
		accountUserVO.setCurrency(CurrencyType.BRL);
		accountUserVO.setDocumentID("321321-XXX");
		accountUserVO.setEmail("fulana@tal.com");
		accountUserVO.setName("Fulana de Tal");
		accountUserVO.setPhoneNumber("(61) 999999-1111");

		accountService.createAccount(accountUserVO);
	}

}
