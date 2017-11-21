package com.sk.kata.service;

import com.sk.kata.converter.OperationConverter;
import com.sk.kata.exception.AccountException;
import com.sk.kata.exception.OperationException;
import com.sk.kata.model.business.Operation;
import com.sk.kata.model.business.OperationType;
import com.sk.kata.model.dto.OperationsDto;
import com.sk.kata.model.entity.AccountEntity;
import com.sk.kata.model.entity.OperationEntity;
import com.sk.kata.repository.AccountRepository;
import com.sk.kata.repository.OperationRepository;
import com.sk.kata.util.Constants;
import com.sk.kata.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sambakamara on 19/11/2017.
 */

@Service
public class AccountServiceImpl implements  AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    OperationConverter operationConverter;


    public Operation deposit(String accountNumber, int amount) {
        checkAmount (amount);

        AccountEntity account = getAccount (accountNumber);

        int balance =  account.getBalance();
        balance = balance + amount;

        OperationEntity operation = new OperationEntity();
        operation.setAccount(accountNumber);
        operation.setAmount(amount);
        operation.setType(OperationType.DEPOSIT.toString());
        operation.setDate(DateUtil.getCurrentDate());
        operation.setBalance(balance);

        operationRepository.save(operation);

        //update account balance
        account.setBalance(balance);
        accountRepository.save(account);

        return  operationConverter.convert(operation);
    }

    public Operation withdraw(String accountNumber, int amount) {
        checkAmount (amount);

        AccountEntity account = getAccount (accountNumber);

        int balance = account.getBalance();
        balance = balance - amount;
        if(balance < 0){
            throw new OperationException(Constants.ERROR_INVALID_OPERATION);
        }

        OperationEntity operation = new OperationEntity();
        operation.setBalance(balance);
        operation.setAccount(accountNumber);
        operation.setAmount(amount);
        operation.setType(OperationType.WITHDRAW.toString());
        operation.setDate(DateUtil.getCurrentDate());

        operationRepository.save(operation);

        //update account balance
        account.setBalance(balance);
        accountRepository.save(account);

        return  operationConverter.convert(operation);
    }

    public OperationsDto history(String accountNumber) {
        List<OperationEntity>  operations = operationRepository.findByAccount(accountNumber);
        return operationConverter.convertList(operations);
    }

    private AccountEntity getAccount(String accountNumber){

        AccountEntity account = accountRepository.findByNumber(accountNumber);

        if(account == null) {
            throw new AccountException(Constants.ERROR_INVALID_ACCOUNT);
        }

        return account;
    }

    private void checkAmount (int amount) {
        if(amount < 0){
            throw new OperationException(Constants.ERROR_INVALID_OPERATION);
        }
    }
}
