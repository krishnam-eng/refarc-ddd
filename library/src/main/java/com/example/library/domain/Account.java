package com.example.library.domain;

import com.example.library.constant.AccountStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Account {
    private Integer id;
    private String password;
    private AccountStatus accountStatus;
    private Person person;
}
