package com.example.library.model.user;

import com.example.library.constant.AccountStatus;
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
