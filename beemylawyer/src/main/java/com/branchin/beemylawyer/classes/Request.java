package com.branchin.beemylawyer.classes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="request")
public class Request {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name="lawyerid")
    private String lawyerId;
    @Column(name="lawyername")
    private String lawyerName;
    @Column(name="creationdate")
    private String creationDate;
    @Column(name="state")
    private String state;
    @Column(name = "clientname")
    private String clientName;
    @Column(name="phonenumber")
    private String phoneNumber;
    @Column(name="clientemail")
    private String clientEmail;
    @Column(name = "description")
    private String description;
}
