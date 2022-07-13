package com.branchin.beemylawyer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfilDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("useremail")
    private String useremail;
    @JsonProperty("fname")
    private String fname;
    @JsonProperty("lname")
    private String lname;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("cposition")
    private String cposition;
    @JsonProperty("skills")
    private ArrayList<String> skills=new ArrayList<>();
    @JsonProperty("pic")
    private String pic;
    @JsonProperty("phonenumber")
    private String phonenumber;
}
