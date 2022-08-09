package com.branchin.beemylawyer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class RequestDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("lawyerId")
    private String lawyerId;
    @JsonProperty("lawyerName")
    private String lawyerName;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("state")
    private String state;
    @JsonProperty("clientName")
    private String clientName;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("clientEmail")
    private String clientEmail;
    @JsonProperty("description")
    private String description;
}
