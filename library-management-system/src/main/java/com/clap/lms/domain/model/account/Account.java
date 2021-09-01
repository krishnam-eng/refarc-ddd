package com.clap.lms.domain.model.account;

import com.clap.lms.domain.data.Person;
import com.clap.lms.domain.constant.AccountStatus;
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
