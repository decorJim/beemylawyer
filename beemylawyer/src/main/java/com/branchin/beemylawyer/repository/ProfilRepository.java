package com.branchin.beemylawyer.repository;

import com.branchin.beemylawyer.classes.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilRepository extends JpaRepository<Profil,String> {
   Profil findByUseremail(String email);
}
