package com.worldnettps.simplebanking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldnettps.simplebanking.model.TransactionDeposit;

@Repository
public interface DepositRepository extends CrudRepository<TransactionDeposit, Long> {

}
