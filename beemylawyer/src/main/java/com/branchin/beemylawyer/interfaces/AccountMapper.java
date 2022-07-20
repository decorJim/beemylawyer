package com.branchin.beemylawyer.interfaces;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE= Mappers.getMapper(AccountMapper.class);

    @Mapping(source="id",target = "id")
    AccountDTO accountToAccountDTO(Account account);
    @Mapping(source="id",target = "id")
    Account accountDTOtoAccount(AccountDTO dto);
}
