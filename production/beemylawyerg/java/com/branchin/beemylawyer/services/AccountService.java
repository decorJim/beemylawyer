package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    Logger logger= LoggerFactory.getLogger(AccountService.class);
    public Account create(Account account) {
        logger.info(String.valueOf(account.getId()));
        logger.info(account.getUseremail());
        logger.info("encrypted:"+account.getPassword());
        if(this.accountRepository.findByUseremail(account.getUseremail())!=null) {
            logger.info("email already exists");
            throw new IllegalStateException();
        }
        try {
            return accountRepository.save(account);
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return account;
        }
    }

    public Account getAccountByUseremail(String email) {
        try {
            return accountRepository.findByUseremail(email);
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            Account dummy=new Account();
            return dummy;
        }
    }

    public Account saveSignIn(Account account) {
        try {
            return accountRepository.save(account);
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return account;
        }
    }

    public Account signOut(Account account) {
        try {
            return accountRepository.save(account);
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return account;
        }
    }

    public Account editAccount(Account account) {
        try {
            return accountRepository.save(account);
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return account;
        }
    }

    public List<Account> getAllAccount() {
        List<Account> accounts=new ArrayList<>();
        try {
            accounts=this.accountRepository.findAll();
            return accounts;
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return accounts;
        }
    }

    public Account getAccountById(String id) {
        try {
            return this.accountRepository.findById(id).get();
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return new Account();
        }
    }

}
