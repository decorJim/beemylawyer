package com.branchin.beemylawyer.builders;

import com.branchin.beemylawyer.classes.Account;

import java.util.ArrayList;

public class AccountBuilder implements Builder {

    private String id;
    private String fname;
    private String lname;
    private String useremail;
    private String password;
    private String phonenumber;
    private String bio;
    private String cposition;
    private ArrayList<String> skills=new ArrayList<>();
    private String pic;
    private String signIn;
    private String signOut;
    private boolean signedIn;
    private Integer stars;


    @Override
    public AccountBuilder id(String id) {
        this.id=id;
        return this;
    }

    @Override
    public AccountBuilder fname(String fname) {
        this.fname=fname;
        return this;
    }

    @Override
    public AccountBuilder lname(String lname) {
        this.lname=lname;
        return this;
    }

    public AccountBuilder useremail(String mail) {
        this.useremail=mail;
        return this;
    }

    public AccountBuilder password(String password) {
        this.password=password;
        return this;
    }

    public AccountBuilder phonenumber(String phonenumber) {
        this.phonenumber=phonenumber;
        return this;
    }

    public AccountBuilder bio(String bio) {
        this.bio=bio;
        return this;
    }

    public AccountBuilder cposition(String cposition) {
        this.cposition=cposition;
        return this;
    }

    public AccountBuilder skills(ArrayList<String> skills) {
        this.skills=skills;
        return this;
    }

    public AccountBuilder pic(String pic) {
        this.pic=pic;
        return this;
    }

    public AccountBuilder signIn(String signIn) {
        this.signIn=signIn;
        return this;
    }

    public AccountBuilder signOut(String singOut) {
        this.signOut=singOut;
        return this;
    }

    public AccountBuilder signedIn(Boolean signedIn) {
        this.signedIn=signedIn;
        return this;
    }

    public AccountBuilder stars(Integer stars) {
        this.stars=stars;
        return this;
    }

    public Account build() {
        return new Account(
                this.id,
                this.useremail,
                this.password,
                this.fname,
                this.lname,
                this.phonenumber,
                this.bio,
                this.cposition,
                this.skills,
                this.pic,
                this.signIn,
                this.signOut,
                this.signedIn,
                this.stars
        );
    }
}
