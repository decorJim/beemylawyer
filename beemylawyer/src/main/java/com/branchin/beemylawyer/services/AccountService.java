package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.classes.Request;
/**
import com.branchin.beemylawyer.repository.AccountRepository;
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
import org.springframework.beans.factory.annotation.Autowired;
 */
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AccountService {

    /**
    @Autowired
    AccountRepository accountRepository;
    */
    public ArrayList<Account> accounts=new ArrayList<>() {{
        ArrayList<String> skills=new ArrayList<>();
        skills.addAll(Arrays.asList("communication","analytics","law documentation"));
        add(new Account(
                "1",
                "mikaelst@hotmail.ca",
                "abc",
                "mikael",
                "steward",
                "5147384985",
                "professional lawyer since 2009",
                "lawyer at CBK",
                skills,
                "/a/ond.png",
                "yes",
                "no",
                false,
                5
        ));

        add(new Account(
                "2",
                "ajlop@hotmail.ca",
                "abc",
                "ajio",
                "lopis",
                "5147384985",
                "professional lawyer since 2002",
                "lawyer at CBC",
                skills,
                "/a/ond.png",
                "yes",
                "no",
                false,
                5
        ));
        add(new Account(
                "3",
                "akeol@hotmail.ca",
                "abc",
                "akeol",
                "alkos",
                "5140948003",
                "professional lawyer since 2019",
                "lawyer at CBK",
                skills,
                "/a/ond.png",
                "yes",
                "no",
                true,
                5
        ));
        add(new Account(
                "4",
                "angeki@hotmail.ca",
                "abc",
                "angekis",
                "lapis",
                "5147384985",
                "professional lawyer since 2009",
                "lawyer at CBK",
                skills,
                "/a/ond.png",
                "yes",
                "no",
                true,
                5
        ));
        add(new Account(
                "5",
                "salami@hotmail.ca",
                "abc",
                "salami",
                "dorius",
                "5144983908",
                "professional lawyer since 2020",
                "lawyer at CBK",
                skills,
                "/a/ond.png",
                "yes",
                "no",
                true,
                5
        ));
    }};

    public ArrayList<Account> signedIn=new ArrayList<>();

    Logger logger= LoggerFactory.getLogger(AccountService.class);
    public Account create(Account account) {
        logger.info(String.valueOf(account.getId()));
        logger.info(account.getUseremail());
        logger.info("encrypted:"+account.getPassword());
        /**
        if(this.accountRepository.findByUseremail(account.getUseremail())!=null) {
            logger.info("email already exists");
            throw new IllegalStateException();
        }
         */
        if (this.accounts.contains(account)) {
            logger.info("account already exists");
            throw new IllegalStateException();
        }
        try {
            /**
            return accountRepository.save(account);
             */
            return account;
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return account;
        }
    }

    public Account getAccountByUseremail(String email) {
        try {
            /**
            return accountRepository.findByUseremail(email);
             */

            Account foundAccount=this.accounts.stream().filter(account -> account.getUseremail()==email).findFirst().get();
            if (foundAccount!=null) {
                return foundAccount;
            }
            return new Account();
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            Account dummy=new Account();
            return dummy;
        }
    }

    public Account saveSignIn(Account account) {
        try {
            /**
            return accountRepository.save(account);
             */
            this.signedIn.add(account);
            return account;
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return account;
        }
    }

    public Account signOut(Account account) {
        try {
            /**
             return accountRepository.save(account);
             */
            this.signedIn.remove(account);
            return account;
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return account;
        }
    }

    public Account editAccount(Account account) {
        try {
            /**
            return accountRepository.save(account);
             */
            Account foundAccount=this.accounts.stream().filter(acc->acc.getId()==account.getId()).findFirst().get();
            int index=this.accounts.indexOf(foundAccount);
            if (index!=-1) {
                this.accounts.set(index,account);
                return account;
            }
            return new Account();
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return account;
        }
    }

    public List<Account> getAllAccount() {
        try {

            /**
             List<Account> accounts=new ArrayList<>();
            accounts=this.accountRepository.findAll();
             */
            return this.accounts;
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return new ArrayList<>();
        }
    }

    public Account getAccountById(String id) {
        try {
            /**
             return this.accountRepository.findById(id).get();
             */
            Account account=this.accounts.stream().filter(acc -> acc.getId()==id).findFirst().get();
            return account;
        }
        catch(Exception e) {
            logger.debug(e.getMessage());
            return new Account();
        }
    }

}
