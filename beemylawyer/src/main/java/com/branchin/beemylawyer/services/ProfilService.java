package com.branchin.beemylawyer.services;


import com.branchin.beemylawyer.classes.Profil;
import com.branchin.beemylawyer.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilService {

    @Autowired
    ProfilRepository profilRepository;

    public Profil createProfil(Profil profil) {
        return profilRepository.save(profil);
    }

    public Profil getProfilByUseremail(String mail) {
        return profilRepository.findByUseremail(mail);
    }

    public Profil editProfil(Profil newProfil) {
        return this.profilRepository.save(newProfil);
    }
}
