package com.sk.kata.model.dto;

import com.sk.kata.model.business.Operation;

import java.util.List;

/**
 * Created by Samba Kamara on 21/11/2017.
 */
public class OperationsDto {

    private List<Operation> operations;

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
