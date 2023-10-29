package com.branchin.beemylawyer.classes;

import lombok.*;

import javax.persistence.*;

/**
@Entity
@Data
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/**
@Table(name="lawyer")
*/
public class Lawyer {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id")
    private String id;
    //@Column(name = "fname")
    private String fname;
    //@Column(name = "lname")
    private String lname;
    //@Column(name = "bio")
    private String bio;
    //@Column(name = "stars")
    private Integer stars;


    public Lawyer(String id,String fname, String lname, String bio, int stars) {
        this.id=id;
        this.fname=fname;
        this.lname=lname;
        this.bio=bio;
        this.stars=stars;
    }



}
