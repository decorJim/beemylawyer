package com.branchin.beemylawyer.controllers;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.dto.ProfilDTO;
import com.branchin.beemylawyer.services.AccountService;
import com.branchin.beemylawyer.services.ProfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class userController {

    Logger logger= LoggerFactory.getLogger(userController.class);

    @Autowired
    AccountService accountService;

    @Autowired
    ProfilService profilService;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping(value = "/user/profil/{useremail}")
    public ResponseEntity<ProfilDTO> getUserprofil(@PathVariable String useremail) {
        Account account=this.accountService.getAccountByUseremail(useremail);
        if(account!=null) {
            ProfilDTO profilDTO=this.profilService.getProfilFromAccount(account);
            return new ResponseEntity<>(profilDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/profil/id/{id}")
    public ResponseEntity<ProfilDTO> getLawyerProfil(@PathVariable String id) {
        Account account=this.accountService.getAccountById(id).get();
        if(account!=null) {
            ProfilDTO profilDTO=this.profilService.getProfilFromAccount(account);
            return new ResponseEntity<>(profilDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/user/profil/modify")
    public ResponseEntity<ProfilDTO> editUserprofil(@RequestBody ProfilDTO profilDTO) {
        /** Profil newProfil=ProfilMapper.INSTANCE.profilDTOToProfil(profilDTO); ***/
        System.out.println(profilDTO.getSkills());
        Account account = this.accountService.getAccountByUseremail(profilDTO.getUseremail());
        if (account != null) {
            account.setFname(profilDTO.getFname());
            account.setLname(profilDTO.getLname());
            account.setBio(profilDTO.getBio());
            account.setCposition(profilDTO.getCposition());
            account.setSkills(profilDTO.getSkills());
            account.setPic(profilDTO.getPic());
            account.setPhonenumber(profilDTO.getPhonenumber());
            System.out.println(account.getSkills());
            this.accountService.editAccount(account);
            this.simpMessagingTemplate.convertAndSend("/lawyers/editedProfil",profilDTO);
            return new ResponseEntity<>(profilDTO, HttpStatus.OK);
        }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value="/user/profil/all")
    public ResponseEntity<List<ProfilDTO>> getAllProfil() {
        List<Account> accounts=this.accountService.getAllAccount();
        List<ProfilDTO> profils=new ArrayList<>();
        for(Account account:accounts) {
            profils.add(this.profilService.getProfilFromAccount(account));
        }
        return new ResponseEntity<>(profils,HttpStatus.OK);
    }


    @MessageMapping("/profil")   /*** client sends data to URL /app/profil to reach this websocket ***/
    @SendTo("/lawyers/public")   /*** client who wants to receive message from this function will listen to the topic
                                     /lawyers/public ***/
    public ProfilDTO receiveNewProfil(@Payload ProfilDTO profilDTO) {
        logger.info("websocket profil received");
        logger.info(profilDTO.getBio());
       return profilDTO;
    }

    @MessageMapping("random")
    @SendTo("/lawyers/randomDes")
    public String receiveRan(@Payload String msg) {
        logger.info(msg);
        return "123456";
    }


    /*** dynamically create a topic ***/
    @MessageMapping("private/msg")
    public ProfilDTO receivePrivateProfil(@Payload ProfilDTO profilDTO) {
        /***
             automatically take the user destination prefix defined in config /user with function convertAndSendToUser
             /user/bob/private the name will take any given value as Fname
         ***/
        simpMessagingTemplate.convertAndSendToUser(profilDTO.getFname(),"/private",profilDTO);
        logger.info("Private routing received profil");
        logger.info("profilId:",profilDTO.getId());
        return profilDTO;
    }
}
