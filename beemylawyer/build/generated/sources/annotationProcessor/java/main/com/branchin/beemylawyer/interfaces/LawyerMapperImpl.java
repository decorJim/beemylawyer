package com.branchin.beemylawyer.interfaces;

import com.branchin.beemylawyer.classes.Lawyer;
import com.branchin.beemylawyer.dto.LawyerDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T13:57:52-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2.1 (Amazon.com Inc.)"
)
public class LawyerMapperImpl implements LawyerMapper {

    @Override
    public LawyerDTO lawyertoLawyerDTO(Lawyer lawyer) {
        if ( lawyer == null ) {
            return null;
        }

        LawyerDTO lawyerDTO = new LawyerDTO();

        lawyerDTO.setId( lawyer.getId() );
        lawyerDTO.setFname( lawyer.getFname() );
        lawyerDTO.setLname( lawyer.getLname() );
        lawyerDTO.setBio( lawyer.getBio() );
        if ( lawyer.getStars() != null ) {
            lawyerDTO.setStars( lawyer.getStars() );
        }

        return lawyerDTO;
    }

    @Override
    public Lawyer lawyerDTOtoLawyer(LawyerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Lawyer lawyer = new Lawyer();

        lawyer.setId( dto.getId() );
        lawyer.setFname( dto.getFname() );
        lawyer.setLname( dto.getLname() );
        lawyer.setBio( dto.getBio() );
        lawyer.setStars( dto.getStars() );

        return lawyer;
    }
}
