package com.branchin.beemylawyer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignInDTO {
    @JsonProperty("useremail")
    public String useremail;
    @JsonProperty("signedindate")
    public Date signedindate;
}
