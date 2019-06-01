package com.worldnettps.simplebanking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldnettps.simplebanking.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
