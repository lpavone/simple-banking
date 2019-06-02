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

@CrossOrigin
@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController extends AbstractController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON, path="/{accountNumber}")
	public ResponseEntity<List<ReceiptDTO>> getAllTransactions(
			@PathVariable Long accountNumber){
		
		// TODO - fazer validações
		
		List<ReceiptDTO> transactions = transactionService.getAllTransactions(accountNumber);
		return body(transactions);
	}
	
	@PostMapping(path="/deposit", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<ReceiptDTO> makeDeposit(@RequestBody DepositDTO depositDTO){
		
		// TODO - fazer validações
		
		ReceiptDTO depositMade = transactionService.makeDeposit(depositDTO);
		return body(depositMade);
	}
	
	@PostMapping(path="/transfer", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<ReceiptDTO> transferFunds(@RequestBody TransferDTO transferDTO){
		
		// TODO - fazer validações
		
		ReceiptDTO transferMade = transactionService.transferFunds(transferDTO);
		return body(transferMade);
	}
	
}
