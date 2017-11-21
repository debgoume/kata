package com.sk.kata.controller;

import com.sk.kata.model.business.Operation;
import com.sk.kata.model.dto.DepositDto;
import com.sk.kata.model.dto.OperationsDto;
import com.sk.kata.model.dto.WithdrawDto;
import com.sk.kata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sambakamara on 19/11/2017.
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/deposit", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Operation deposit (@RequestBody DepositDto depositDto) {

        return accountService.deposit(depositDto.getAccountNumber(), depositDto.getAmount());
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Operation withdraw (@RequestBody WithdrawDto withdrawDto) {

        return accountService.withdraw(withdrawDto.getAccountNumber(), withdrawDto.getAmount());
    }

    @RequestMapping(value = "/history/{accountNumber}", produces = "application/json")
    @ResponseBody
    public OperationsDto history (@PathVariable (value = "accountNumber") String accountNumber) {
        return accountService.history(accountNumber);
    }

}
