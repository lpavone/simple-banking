package com.worldnettps.simplebanking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldnettps.simplebanking.model.TransactionTransfer;

@Repository
public interface TransferRepository extends CrudRepository<TransactionTransfer, Long> {

}
