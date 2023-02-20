package com.branchin.beemylawyer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {
    @JsonProperty("id")
    public String id;
    @JsonProperty("useremail")
    private String useremail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("fname")
    private String fname;
    @JsonProperty("lname")
    private String lname;
    @JsonProperty("phonenumber")
    private String phonenumber;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("cposition")
    private String cposition;
    @JsonProperty("skills")
    private ArrayList<String> skills=new ArrayList<>();
    @JsonProperty("pic")
    private String pic;
    @JsonProperty("signedindate")
    private String signIn;
    @JsonProperty("signedoutdate")
    private String signOut;
    @JsonProperty("signedin")
    private boolean signedIn;
    @JsonProperty("stars")
    private Integer stars;
}
