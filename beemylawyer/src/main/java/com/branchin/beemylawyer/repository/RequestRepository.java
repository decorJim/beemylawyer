package com.branchin.beemylawyer.repository;

import com.branchin.beemylawyer.classes.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,String> {

}
