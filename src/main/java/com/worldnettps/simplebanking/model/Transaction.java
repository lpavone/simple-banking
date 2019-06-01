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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.worldnettps.simplebanking.model.enums.TransactionType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@EqualsAndHashCode
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransaction;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	@Column
	@Enumerated
	private TransactionType type;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTransaction;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSchedule;
	
	@Column
	private BigDecimal amount;

}
