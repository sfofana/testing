package com.sfofana.bank.service;

import java.util.ArrayList;
import java.util.List;

import com.sfofana.bank.model.Account;
import com.sfofana.bank.model.AccountHolder;
import com.sfofana.bank.repository.AccountHolderRepository;
import com.sfofana.bank.repository.AccountRepository;
import com.sfofana.bank.transfer.Profile;
import com.sfofana.bank.transfer.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public static final String CHECKING = "checking";
    public static final String SAVING = "saving";
    public static final String Deposit = "Deposit";
    public static final String Withdrawal = "Withdrawal";

    @Autowired
    AccountHolderRepository holderRepo;
    @Autowired
    AccountRepository accountRepo;

    public AccountHolder register(AccountHolder holder) {
        AccountHolder accountHolder = holderRepo.save(holder);

        Account checking = new Account(null, UserService.CHECKING, 0.0, accountHolder);
        Account saving = new Account(null, UserService.SAVING, 0.0, accountHolder);
        List<Account> defalutAccounts = List.of(checking, saving);

        accountRepo.saveAll(defalutAccounts);

        return holderRepo.getOne(accountHolder.getId());
    }

    public AccountHolder addAccount(Transaction transaction) {
        AccountHolder holder = holderRepo.getOne(transaction.getHolderId());

        Account newAccount = new Account(null, transaction.getAccountName(), transaction.getAmount(), holder);
        accountRepo.save(newAccount);

        return holderRepo.getOne(transaction.getHolderId());
    }

    public AccountHolder login(Profile profile) throws Exception {
        AccountHolder holder = holderRepo.findyByEmail(profile.getEmail());
        if (holder == null) {
            throw new Exception();
        } else if (holder.getPassword().equals(profile.getPassword())) {
            throw new Exception();
        }
        return holder;
    }

    public AccountHolder updateProfile(Profile profile) {
        AccountHolder holder = holderRepo.findyByEmail(profile.getEmail());
        holder.setAddress(profile.getAddress());
        holder.setDob(profile.getDob());
        holder.setEmail(profile.getEmail());
        holder.setFirstname(profile.getFirstname());
        holder.setLastname(profile.getLastname());
        return holderRepo.save(holder);
    }

    public AccountHolder processTransaction(Transaction transaction, String type) {
        AccountHolder holder = holderRepo.getOne(transaction.getHolderId());
        List<Account> accounts = new ArrayList<>();

        switch (type) {
            case "Deposit":
                holder.getAccounts().stream().forEach(account -> {
                    if (account.getNumber() == transaction.getAccountNumber()) {
                        Double amount = account.getBalance() + transaction.getAmount();
                        account.setBalance(amount);
                    }
                    accounts.add(account);
                });
                break;
            case "Withdrawal":
                holder.getAccounts().stream().forEach(account -> {
                    if (account.getNumber() == transaction.getAccountNumber()) {
                        Double amount = account.getBalance() - transaction.getAmount();
                        account.setBalance(amount);
                    }
                    accounts.add(account);
                });
                break;
        }

        accountRepo.saveAll(accounts);
        return holderRepo.getOne(transaction.getHolderId());
    }

    public AccountHolder processTransfer(Transaction transaction){
        AccountHolder holder = processTransaction(transaction, UserService.Withdrawal);

        AccountHolder reciever = holderRepo.findyByEmail(transaction.getReciverEmail());
        List<Account> accounts = new ArrayList<>();
        reciever.getAccounts().stream().forEach(account -> {
            if (account.getName().equals(UserService.CHECKING)) {
                Double amount = account.getBalance() + transaction.getAmount();
                account.setBalance(amount);
            }
            accounts.add(account);
        });

        accountRepo.saveAll(accounts);
        return holder;
    }
}
