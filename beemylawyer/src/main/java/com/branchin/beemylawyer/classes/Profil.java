package com.branchin.beemylawyer.classes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="profil")
public class Profil {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="useremail")
    private String useremail;
    @Column(name="fname")
    private String fname;
    @Column(name="lname")
    private String lname;
    @Column(name="bio")
    private String bio;
    @Column(name="cposition")
    private String cposition;
    @Column(name="skills")
    private ArrayList<String> skills=new ArrayList<>();
    @Column(name="pic")
    private String pic;
    @Column(name="phonenumber")
    private String phonenumber;



}
