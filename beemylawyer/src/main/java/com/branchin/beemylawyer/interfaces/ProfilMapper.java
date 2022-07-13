package com.branchin.beemylawyer.interfaces;

import com.branchin.beemylawyer.classes.Profil;
import com.branchin.beemylawyer.dto.ProfilDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfilMapper {

    ProfilMapper INSTANCE = Mappers.getMapper( ProfilMapper.class );

    @Mapping(source="id",target = "id")
    public ProfilDTO profilToProfilDTO(Profil profil);

    @Mapping(source="id",target = "id")
    public Profil profilDTOToProfil(ProfilDTO profilDTO);
}
