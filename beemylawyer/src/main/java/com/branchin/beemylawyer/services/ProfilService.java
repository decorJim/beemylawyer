package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.dto.ProfilDTO;
import org.springframework.stereotype.Service;

@Service
public class ProfilService {

    public ProfilDTO getProfilFromAccount(Account account) {
        return new ProfilDTO(
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
    }

}
