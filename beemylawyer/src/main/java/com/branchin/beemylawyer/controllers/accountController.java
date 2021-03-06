package com.branchin.beemylawyer.controllers;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.classes.Lawyer;
import com.branchin.beemylawyer.dto.AccountDTO;
import com.branchin.beemylawyer.dto.LawyerDTO;
import com.branchin.beemylawyer.dto.LoginDTO;
import com.branchin.beemylawyer.dto.ResponseDTO;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class accountController {

    Logger logger= LoggerFactory.getLogger(accountController.class);
    @Autowired
    private LawyerService lawyerService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private ProfilService profilService;

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
        return new ResponseEntity<>(LawyerMapper.INSTANCE.lawyerToLawyerDTO(lawyerService.create(l1)),HttpStatus.CREATED);
    }


    @PostMapping(value="/account/createAccount")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        logger.info("CREATE ACCOUNT");
        logger.info(accountDTO.toString());

        if(this.accountService.getAccountByUseremail(accountDTO.getUseremail())!=null) {
            return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
        }

        UUID uuid = UUID.randomUUID();
        accountDTO.setId(String.valueOf(uuid));

        logger.info(accountDTO.getFname());
        logger.info(accountDTO.getLname());

        String encryptedPassword=this.passwordEncoder.encode(accountDTO.getPassword());
        accountDTO.setPassword(encryptedPassword);
        Account a1=AccountMapper.INSTANCE.accountDTOtoAccount(accountDTO);
        return new ResponseEntity<>(AccountMapper.INSTANCE.accountToAccountDTO(accountService.create(a1)),HttpStatus.CREATED);
    }

    @PostMapping(value = "/account/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO login) {
        Account account=accountService.getAccountByUseremail(login.getUseremail());
        if(account!=null) {
            logger.info("ACCOUNT FOUND");
            if (passwordEncoder.matches(login.getPassword(), account.getPassword())) {
                logger.info("MATCHES");
                Date date=new Date();
                account.setSignIn(date);
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
            Date date=new Date();
            account.setSignOut(date);
            this.accountService.signOut(account);
            ResponseDTO responseDTO=new ResponseDTO("SUCCESS");
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
        ResponseDTO responseDTO=new ResponseDTO("NOT FOUND");
        return new ResponseEntity<>(responseDTO,HttpStatus.NOT_FOUND);
    }
}
