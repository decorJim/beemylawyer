package com.branchin.beemylawyer.interfaces;

import com.branchin.beemylawyer.classes.Lawyer;
import com.branchin.beemylawyer.dto.LawyerDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-04T18:00:26-0400",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class LawyerMapperImpl implements LawyerMapper {

    @Override
    public LawyerDTO lawyerToLawyerDTO(Lawyer lawyer) {
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
