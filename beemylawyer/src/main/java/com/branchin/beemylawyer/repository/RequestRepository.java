/**
package com.branchin.beemylawyer.repository;

import com.branchin.beemylawyer.classes.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request,String> {
   List<Request> findAllByLawyerId(String lawyerId);
}
*/