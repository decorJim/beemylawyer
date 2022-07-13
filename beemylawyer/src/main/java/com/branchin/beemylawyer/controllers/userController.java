package com.branchin.beemylawyer.controllers;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.classes.Profil;
import com.branchin.beemylawyer.dto.ProfilDTO;
import com.branchin.beemylawyer.interfaces.ProfilMapper;
import com.branchin.beemylawyer.services.AccountService;
import com.branchin.beemylawyer.services.ProfilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {

    Logger logger= LoggerFactory.getLogger(userController.class);

    @Autowired
    ProfilService profilService;
    @Autowired
    AccountService accountService;

    @GetMapping(value = "/user/profil/{useremail}")
    public ResponseEntity<ProfilDTO> getUserprofil(@PathVariable String useremail) {
        Account account=this.accountService.getAccountByUseremail(useremail);
        ProfilDTO profilDTO=new ProfilDTO(
                account.getId(),
                account.getUseremail(),
                account.getFname(),
                account.getLname(),
                account.getBio(),
                account.getCposition(),
                account.getSkills(),
                account.getPic(),
                account.getPhonenumber()
        );
       return new ResponseEntity<>(profilDTO, HttpStatus.OK);
    }

    @PutMapping(value="/user/profil/modify")
    public ResponseEntity<ProfilDTO> editUserprofil(@RequestBody ProfilDTO profilDTO) {
        /** Profil newProfil=ProfilMapper.INSTANCE.profilDTOToProfil(profilDTO); ***/
        Account account=this.accountService.getAccountByUseremail(profilDTO.getUseremail());
        account.setFname(profilDTO.getFname());
        account.setLname(profilDTO.getLname());
        account.setBio(profilDTO.getBio());
        account.setCposition(profilDTO.getCposition());
        account.setSkills(profilDTO.getSkills());
        account.setPic(profilDTO.getPic());
        account.setPhonenumber(profilDTO.getPhonenumber());
        this.accountService.editAccount(account);
        return new ResponseEntity<>(profilDTO,HttpStatus.OK);
    }
}
