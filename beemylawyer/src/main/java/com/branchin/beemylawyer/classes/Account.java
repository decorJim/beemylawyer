package com.branchin.beemylawyer.classes;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="account")
public class Account {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name="useremail")
    private String useremail;
    @Column(name = "password")
    private String password;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name="phonenumber")
    private String phonenumber;
    @Column(name="bio")
    private String bio;
    @Column(name="cposition")
    private String cposition;
    @Column(name="skills")
    private ArrayList<String> skills=new ArrayList<>();
    @Column(name="pic")
    private String pic;
    @Column(name="signedindate")
    private Date signIn;
    @Column(name="signedoutdate")
    private Date signOut;
}
