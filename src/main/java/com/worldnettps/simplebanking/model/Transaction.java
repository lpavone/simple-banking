package com.worldnettps.simplebanking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.worldnettps.simplebanking.model.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long idTransaction;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	protected Account account;
	
	@Column
	@Enumerated
	protected TransactionType type;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	protected Date transactionDate;
	
	@Column
	protected BigDecimal amount;
	
	/*
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dateSchedule;
	 */

}
