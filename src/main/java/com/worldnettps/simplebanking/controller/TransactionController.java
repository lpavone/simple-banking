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

import com.worldnettps.simplebanking.dto.DepositDTO;
import com.worldnettps.simplebanking.dto.ReceiptDTO;
import com.worldnettps.simplebanking.dto.TransferDTO;
import com.worldnettps.simplebanking.service.TransactionService;
import com.worldnettps.simplebanking.util.SimpleBankingUtil;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController extends AbstractController {
	
	@Autowired
	private TransactionService transactionService;
	
	@ApiOperation(value = "Get all transactions by account number")
	@GetMapping(produces = MediaType.APPLICATION_JSON, path="/{accountNumber}")
	public ResponseEntity<List<ReceiptDTO>> getAllTransactions(
			@PathVariable Long accountNumber){
		
		SimpleBankingUtil.validateData(accountNumber, "Account number");
		
		List<ReceiptDTO> transactions = transactionService.getAllTransactions(accountNumber);
		return body(transactions);
	}
	
	@ApiOperation(value = "Make a new deposit value in account")
	@PostMapping(path="/deposit", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<ReceiptDTO> makeDeposit(@RequestBody DepositDTO depositDTO){
		
		SimpleBankingUtil.validateUser(depositDTO.getIdUser());
		
		SimpleBankingUtil.validateData(depositDTO.getAccountNumber(), "Account number");
		SimpleBankingUtil.validateData(depositDTO.getAmount(), "Amount");
		SimpleBankingUtil.validateData(depositDTO.getDate(), "Date");
		
		ReceiptDTO depositMade = transactionService.makeDeposit(depositDTO);
		return body(depositMade);
	}
	
	@ApiOperation(value = "Transfer funds between accounts")
	@PostMapping(path="/transfer", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<ReceiptDTO> transferFunds(@RequestBody TransferDTO transferDTO){
		
		SimpleBankingUtil.validateUser(transferDTO.getIdUser());
		
		SimpleBankingUtil.validateData(transferDTO.getAccountNumber(), "Account number");
		SimpleBankingUtil.validateData(transferDTO.getAccountNumberTo(), "Account number TO");
		SimpleBankingUtil.validateData(transferDTO.getAmount(), "Amount");
		SimpleBankingUtil.validateData(transferDTO.getDate(), "Date");
		
		ReceiptDTO transferMade = transactionService.transferFunds(transferDTO);
		return body(transferMade);
	}
	
}
