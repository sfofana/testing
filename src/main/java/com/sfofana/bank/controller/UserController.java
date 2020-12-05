package com.sfofana.bank.controller;

import com.sfofana.bank.model.AccountHolder;
import com.sfofana.bank.service.UserService;
import com.sfofana.bank.transfer.Profile;
import com.sfofana.bank.transfer.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService service;

    @PostMapping("")
    public AccountHolder register(@RequestBody AccountHolder holder){
        return service.register(holder);
    }

    @PostMapping("")
    public AccountHolder login(@RequestBody Profile profile) throws Exception {
        return service.login(profile);
    }

    @PostMapping("")
    public AccountHolder applyForAccount(@RequestBody Transaction transaction) {
        return service.addAccount(transaction);
    }

    @PutMapping("")
    public AccountHolder deposit(@RequestBody Transaction transaction){
        return service.processTransaction(transaction, UserService.Deposit);
    }

    @PutMapping("")
    public AccountHolder withdraw(@RequestBody Transaction transaction){
        return service.processTransaction(transaction, UserService.Withdrawal);
    }

    @PutMapping("")
    public AccountHolder transfer(@RequestBody Transaction transaction){
        return service.processTransfer(transaction);
    }
}
