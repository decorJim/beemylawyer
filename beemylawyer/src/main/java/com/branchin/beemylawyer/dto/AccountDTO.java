package com.branchin.beemylawyer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {
    @JsonProperty("id")
    public String id;
    @JsonProperty("useremail")
    public String useremail;
    @JsonProperty("password")
    public String password;
    @JsonProperty("fname")
    public String fname;
    @JsonProperty("lname")
    public String lname;
    @JsonProperty("phonenumber")
    public String phonenumber;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("cposition")
    private String cposition;
    @JsonProperty("skills")
    private ArrayList<String> skills=new ArrayList<>();
    @JsonProperty("pic")
    private String pic;
    @JsonProperty("signedindate")
    private Date signIn;
    @JsonProperty("signedoutdate")
    private Date signOut;
    @JsonProperty("signedin")
    private boolean signedIn;
    @JsonProperty("stars")
    private Integer stars;
}
