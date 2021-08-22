package com.example.library.model.entity.account;

import com.example.library.constant.AccountStatus;
import com.example.library.model.value.Person;
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
