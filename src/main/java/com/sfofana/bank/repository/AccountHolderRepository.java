package com.sfofana.bank.repository;

import com.sfofana.bank.model.AccountHolder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {

    public AccountHolder findyByEmail(String email);
}
