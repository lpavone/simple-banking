package com.worldnettps.simplebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.worldnettps.simplebanking.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	@Query(value = " SELECT distinct t "
			+ " FROM Balance b "
			+ " JOIN b.transaction t "
			+ " WHERE b.accountNumber = :accountNumber "
			+ " ORDER BY t.transactionDate ")
	public List<? extends Transaction> getAllTransaction(@Param("accountNumber") Long accountNumber);

}
