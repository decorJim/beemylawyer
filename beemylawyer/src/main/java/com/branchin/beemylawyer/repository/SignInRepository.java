package com.branchin.beemylawyer.repository;

import com.branchin.beemylawyer.classes.SignIn;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SignInRepository extends JpaRepository<SignIn,String> {
    Integer deleteByUseremail(String email);
}
