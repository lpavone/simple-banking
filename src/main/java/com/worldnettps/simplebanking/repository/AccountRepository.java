package com.worldnettps.simplebanking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldnettps.simplebanking.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
