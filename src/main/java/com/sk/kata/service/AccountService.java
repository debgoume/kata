package com.sk.kata.service;

import com.sk.kata.model.business.Operation;
import com.sk.kata.model.dto.OperationsDto;

import java.util.List;

/**
 * Created by sambakamara on 19/11/2017.
 */

public interface AccountService {

    public Operation deposit(String accountNumber, int amount);
    public Operation withdraw(String accountNumber, int amount);
    public OperationsDto history(String accountNumber);
}
