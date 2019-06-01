package com.worldnettps.simplebanking.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="transaction_id")
public class TransactionTransfer extends Transaction {
	
	@ManyToOne
	@JoinColumn(name="accountToNumber")
	private Account accountTo;

	@ManyToOne
	@JoinColumn(name="accountFromNumber")
	private Account accountFrom;
	
}
