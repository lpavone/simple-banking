package com.worldnettps.simplebanking.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="transaction_id")
@EqualsAndHashCode(callSuper=true)
public class TransactionTransfer extends Transaction {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="account_from_number")
	private Account accountFrom;
	
}
