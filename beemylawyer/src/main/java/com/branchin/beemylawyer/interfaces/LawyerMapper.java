package com.branchin.beemylawyer.interfaces;


import com.branchin.beemylawyer.classes.Lawyer;
import com.branchin.beemylawyer.dto.LawyerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LawyerMapper {

    LawyerMapper INSTANCE = Mappers.getMapper( LawyerMapper.class );
    @Mapping(source="id",target = "id")
    LawyerDTO lawyerToLawyerDTO(Lawyer lawyer);
    @Mapping(source="id",target = "id")
    Lawyer lawyerDTOtoLawyer(LawyerDTO dto);

}
