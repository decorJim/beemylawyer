package com.branchin.beemylawyer.controllers;


import com.branchin.beemylawyer.builders.AccountBuilder;
import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.classes.Lawyer;
import com.branchin.beemylawyer.dto.*;
import com.branchin.beemylawyer.interfaces.AccountMapper;
import com.branchin.beemylawyer.interfaces.LawyerMapper;
import com.branchin.beemylawyer.services.AccountService;
import com.branchin.beemylawyer.services.LawyerService;
import com.branchin.beemylawyer.services.ProfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class accountController {

    Logger logger= LoggerFactory.getLogger(accountController.class);

    @Autowired
    AccountService accountService;

    @Autowired
    ProfilService profilService;

    @Autowired
    LawyerService lawyerService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


    @PostMapping(value="/createLawyer")
    public ResponseEntity<LawyerDTO> createLawyer(@RequestBody LawyerDTO lawyerDTO) {
        UUID uuid = UUID.randomUUID();
        lawyerDTO.setId(String.valueOf(uuid));
        logger.info("CREATE LAWYER");
        logger.info(lawyerDTO.toString());
        lawyerDTO.setStars(0);

        logger.info(lawyerDTO.getFname());
        logger.info(lawyerDTO.getLname());
        logger.info(lawyerDTO.getBio());
        logger.info(String.valueOf(lawyerDTO.getStars()));
        Lawyer l1=LawyerMapper.INSTANCE.lawyerDTOtoLawyer(lawyerDTO);
        return new ResponseEntity<>(LawyerMapper.INSTANCE.lawyertoLawyerDTO(lawyerService.create(l1)),HttpStatus.CREATED);
    }


    @PostMapping(value="/account/createAccount")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        if(this.accountService.getAccountByUseremail(accountDTO.getUseremail())!=null) {
            return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
        }
        UUID uuid = UUID.randomUUID();
        String encryptedPassword=this.passwordEncoder.encode(accountDTO.getPassword());
        accountDTO.setId(String.valueOf(uuid));
        accountDTO.setPassword(encryptedPassword);

        /** builder pattern */
        AccountBuilder builder=new AccountBuilder();
        Account newaccount=builder.id(accountDTO.getId())
                .stars(0)
                .password(accountDTO.getPassword())
                .useremail(accountDTO.getUseremail())
                .fname(accountDTO.getFname())
                .lname(accountDTO.getLname())
                .phonenumber(accountDTO.getPhonenumber())
                .bio(accountDTO.getBio())
                .cposition(accountDTO.getCposition())
                .skills(accountDTO.getSkills())
                .pic(accountDTO.getPic())
                .signIn(accountDTO.getSignIn())
                .signOut(accountDTO.getSignOut())
                .signedIn(accountDTO.isSignedIn())
                .stars(accountDTO.getStars())
                .build();

        ProfilDTO profilDTO=this.profilService.getProfilFromAccount(newaccount);
        simpMessagingTemplate.convertAndSend("/lawyers/public",profilDTO);
        return new ResponseEntity<>(AccountMapper.INSTANCE.accountToAccountDTO(accountService.create(newaccount)),HttpStatus.CREATED);
    }

    @PostMapping(value = "/account/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO login) {
        Account account=accountService.getAccountByUseremail(login.getUseremail());
        if(account!=null) {
            logger.info("ACCOUNT FOUND");
            System.out.println(account.getUseremail());
            System.out.println(account.getPassword());
            System.out.println(passwordEncoder.matches(login.getPassword(), account.getPassword()));
            System.out.println("HHHH");
            if (passwordEncoder.matches(login.getPassword(), account.getPassword())) {
                logger.info("MATCHES");

                Date now=new Date();
                String date=now.toString();
                account.setSignIn(date);
                account.setSignedIn(true);
                this.accountService.saveSignIn(account);

                ResponseDTO responseDTO=new ResponseDTO("SUCCESS");
                return new ResponseEntity<>(responseDTO,HttpStatus.OK);
            } else {
                logger.info("WRONG PASSWORD");
                ResponseDTO responseDTO=new ResponseDTO("FAILED");
                return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value="/account/logout")
    public ResponseEntity<ResponseDTO> logout(@RequestBody AccountDTO accountDTO) {
        Account account=accountService.getAccountByUseremail(accountDTO.getUseremail());
        if(account!=null) {
            logger.info("LOGGED OUT");
            logger.info(account.getUseremail());
            Date now=new Date();
            String date=now.toString();
            account.setSignOut(date);
            account.setSignedIn(false);
            this.accountService.signOut(account);
            ResponseDTO responseDTO=new ResponseDTO("SUCCESS");
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
        ResponseDTO responseDTO=new ResponseDTO("NOT FOUND");
        return new ResponseEntity<>(responseDTO,HttpStatus.NOT_FOUND);
    }
}
