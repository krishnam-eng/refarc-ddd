package com.example.library.domain.model.account;

import com.example.library.domain.constant.AccountStatus;
import com.example.library.domain.data.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public abstract class Account {
    private Integer id;
    private String password;
    private AccountStatus accountStatus;
    private Person person;
}
