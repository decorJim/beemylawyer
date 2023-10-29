package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Lawyer;
/**
import com.branchin.beemylawyer.repository.LawyerRepository;
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class LawyerService {

    /**
    @Autowired
    private LawyerRepository lawyerRepository;
    */

    public ArrayList<Lawyer> lawyers=new ArrayList<>() {{

    }};

    Logger logger= LoggerFactory.getLogger(LawyerService.class);

    public Lawyer create(Lawyer lawyer){
        logger.info("CREATED LAWYER OBJECT");
        logger.info("id:"+lawyer.getId());
        logger.info("fname:"+lawyer.getFname());
        logger.info("lname:"+lawyer.getLname());
        logger.info("bio:"+lawyer.getBio());
        logger.info("stars:"+String.valueOf(lawyer.getStars()));

        try {
            /**
            return lawyerRepository.save(lawyer);
             */
            return lawyer;
        }
        catch (Exception e) {
            return lawyer;
        }
    }
}
