package com.worldnettps.simplebanking.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.worldnettps.simplebanking.model.TransactionDeposit;
import com.worldnettps.simplebanking.model.TransactionTransfer;

import lombok.Getter;

@Getter
public class ReceiptDTO {
	
	private Long accountNumber;
	private String userName;
	private Date transactionDate;
	private BigDecimal amount;
	private String description;
	
	/**
	 * Construtor to receipt - transaction deposit
	 * @param transfer - {@link TransactionDeposit}
	 */
	public ReceiptDTO(TransactionDeposit deposit) {
		this.accountNumber = deposit.getAccount().getNumber();
		this.userName = deposit.getAccount().getUser().getName();
		this.transactionDate = deposit.getTransactionDate();
		this.amount = deposit.getAmount();
		this.description = deposit.getType().toString();
	}

	/**
	 * Construtor to receipt - transaction tranfer funds
	 * @param transfer - {@link TransactionTransfer}
	 * @param accountNumber - {@link Long}
	 */
	public ReceiptDTO(TransactionTransfer transfer, Long accountNumber) {
		this.accountNumber = transfer.getAccount().getNumber();
		this.userName = transfer.getAccount().getUser().getName();
		this.transactionDate = transfer.getTransactionDate();
		
		if (transfer.getAccount().getNumber().equals(accountNumber)){
			// Debit
			this.description = "Transfer funds TO account " + transfer.getAccountFrom().getNumber();
			this.amount = transfer.getAmount().multiply(BigDecimal.valueOf(-1));
		} else {
			// Credit
			this.description = "Transfer funds FROM account " + transfer.getAccountFrom().getNumber();
			this.amount = transfer.getAmount();
		}
		
		this.description = transfer.getType().toString();
	}
	
}
