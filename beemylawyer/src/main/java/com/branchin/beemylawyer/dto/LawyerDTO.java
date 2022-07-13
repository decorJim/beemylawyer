package com.branchin.beemylawyer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LawyerDTO implements Serializable {

    @JsonProperty("id")
    public String id;
    @JsonProperty("fname")
    public String fname;
    @JsonProperty("lname")
    public String lname;
    @JsonProperty("bio")
    public String bio;
    @JsonProperty("stars")
    public int stars;



}
