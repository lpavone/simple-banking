package com.worldnettps.simplebanking.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldnettps.simplebanking.model.Balance;

@Repository
public interface BalanceRepository extends CrudRepository<Balance, Long> {
	
	@Query(value = " select b.finalBalance from Account a JOIN a.actualBalance b where a.number = :accountNumber ")
	public BigDecimal getBalanceByAccountNumber(@Param("accountNumber") Long accountNumber);

}
