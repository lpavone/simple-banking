package com.worldnettps.simplebanking.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="transaction_id")
public class TransactionDeposit extends Transaction {
	
}
