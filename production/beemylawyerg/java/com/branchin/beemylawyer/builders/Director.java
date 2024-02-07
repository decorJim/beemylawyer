package com.branchin.beemylawyer.builders;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.dto.AccountDTO;

public class Director {

    public Account buildAccount(AccountDTO accountDTO) {
        AccountBuilder builder=new AccountBuilder();
        Account account=builder.id(accountDTO.getId())
                .stars(0)
                .password(accountDTO.getPassword())
                .useremail(accountDTO.getUseremail())
                .fname(accountDTO.getFname())
                .lname(accountDTO.getLname())
                .phonenumber(accountDTO.getPhonenumber())
                .bio(accountDTO.getBio())
                .cposition(accountDTO.getCposition())
                .skills(accountDTO.getSkills())
                .pic(accountDTO.getPic())
                .signIn(accountDTO.getSignIn())
                .signOut(accountDTO.getSignOut())
                .signedIn(accountDTO.isSignedIn())
                .stars(accountDTO.getStars())
                .build();
        return account;
    }
}
