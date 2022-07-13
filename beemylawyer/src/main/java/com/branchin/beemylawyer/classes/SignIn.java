package com.branchin.beemylawyer.classes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="signedin")
public class SignIn {
    @Id
    @Column(name="useremail")
    private String useremail;
    @Column(name="signedindate")
    private Date signedInDate;
}
