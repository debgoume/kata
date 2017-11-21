package com.sk.kata.repository;

import com.sk.kata.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by sambakamara on 19/11/2017.
 */

public interface AccountRepository extends CrudRepository<AccountEntity, String> {

    AccountEntity findByNumber(String number);
}
