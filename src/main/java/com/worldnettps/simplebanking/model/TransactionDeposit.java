package com.worldnettps.simplebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

import com.worldnettps.simplebanking.model.enums.CardType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="transaction_id")
@EqualsAndHashCode(callSuper=true)
public class TransactionDeposit extends Transaction {
	
	private static final long serialVersionUID = 1L;

	@Column
	private String cardNumber;

	@Column
	private String nameInCard;
	
	@Enumerated
	private CardType cardType;
	
	
}
