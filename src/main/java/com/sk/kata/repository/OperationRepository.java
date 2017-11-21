package com.sk.kata.repository;

import com.sk.kata.model.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sambakamara on 19/11/2017.
 */

public interface OperationRepository  extends CrudRepository<OperationEntity, Integer> {

    List<OperationEntity> findByAccount(String accountNumber);
}
