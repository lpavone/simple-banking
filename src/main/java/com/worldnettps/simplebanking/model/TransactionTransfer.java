package com.worldnettps.simplebanking.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class TransactionTransfer extends Transaction {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="account_from_number")
	private Account accountFrom;

	@Builder(builderMethodName = "transferBuilder")
	public TransactionTransfer(Long idTransaction, Account account, TransactionType type, Date dateTransaction, BigDecimal amount, Account accountFrom) {
		super(idTransaction, account, type, dateTransaction, amount);
		this.accountFrom = accountFrom;
	}
	
}
