package com.branchin.beemylawyer.interfaces;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.dto.AccountDTO;
import java.util.ArrayList;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-19T19:56:45-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO accountToAccountDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( account.getId() );
        accountDTO.setUseremail( account.getUseremail() );
        accountDTO.setPassword( account.getPassword() );
        accountDTO.setFname( account.getFname() );
        accountDTO.setLname( account.getLname() );
        accountDTO.setPhonenumber( account.getPhonenumber() );
        accountDTO.setBio( account.getBio() );
        accountDTO.setCposition( account.getCposition() );
        ArrayList<String> arrayList = account.getSkills();
        if ( arrayList != null ) {
            accountDTO.setSkills( new ArrayList<String>( arrayList ) );
        }
        accountDTO.setPic( account.getPic() );
        accountDTO.setSignIn( account.getSignIn() );
        accountDTO.setSignOut( account.getSignOut() );
        accountDTO.setSignedIn( account.isSignedIn() );
        accountDTO.setStars( account.getStars() );

        return accountDTO;
    }

    @Override
    public Account accountDTOtoAccount(AccountDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( dto.getId() );
        account.setUseremail( dto.getUseremail() );
        account.setPassword( dto.getPassword() );
        account.setFname( dto.getFname() );
        account.setLname( dto.getLname() );
        account.setPhonenumber( dto.getPhonenumber() );
        account.setBio( dto.getBio() );
        account.setCposition( dto.getCposition() );
        ArrayList<String> arrayList = dto.getSkills();
        if ( arrayList != null ) {
            account.setSkills( new ArrayList<String>( arrayList ) );
        }
        account.setPic( dto.getPic() );
        account.setSignIn( dto.getSignIn() );
        account.setSignOut( dto.getSignOut() );
        account.setSignedIn( dto.isSignedIn() );
        account.setStars( dto.getStars() );

        return account;
    }
}
