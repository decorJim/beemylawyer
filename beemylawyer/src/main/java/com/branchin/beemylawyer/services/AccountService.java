package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.classes.Profil;
import com.branchin.beemylawyer.classes.SignIn;
import com.branchin.beemylawyer.dto.ProfilDTO;
import com.branchin.beemylawyer.repository.AccountRepository;
import com.branchin.beemylawyer.repository.SignInRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SignInRepository signInRepository;

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

}
