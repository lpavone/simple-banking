package com.worldnettps.simplebanking.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.worldnettps.simplebanking.model.enums.TransactionType;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table
@PrimaryKeyJoinColumn(name="transaction_id")
public class TransactionDeposit extends Transaction {
	
	private static final long serialVersionUID = 1L;

	@Builder(builderMethodName = "depositBuilder")
	public TransactionDeposit(Long idTransaction, Account account, TransactionType type, Date dateTransaction, BigDecimal amount) {
		super(idTransaction, account, type, dateTransaction, amount);
	}

	/*
	@Column
	private String cardNumber;

	@Column
	private String nameInCard;
	
	@Enumerated
	private CardType cardType;
	*/
	
	
	
	
}
