package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProfilService profilService;

    Logger logger= LoggerFactory.getLogger(AccountService.class);
    public Account create(Account account) {
        logger.info(String.valueOf(account.getId()));
        logger.info(account.getUseremail());
        logger.info("encrypted:"+account.getPassword());
        if(this.accountRepository.findByUseremail(account.getUseremail())!=null) {
            logger.info("email already exists");
            throw new IllegalStateException();
        }
        return accountRepository.save(account);
    }

    public Account getAccountByUseremail(String email) {
        return accountRepository.findByUseremail(email);
    }

    public Account saveSignIn(Account account) {
        return accountRepository.save(account);
    }

    public Account signOut(Account account) {
        return accountRepository.save(account);
    }

    public Account editAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccount() {
        return this.accountRepository.findAll();
    }

    public Optional<Account> getAccountById(String id) {
        return this.accountRepository.findById(id);
    }

}
