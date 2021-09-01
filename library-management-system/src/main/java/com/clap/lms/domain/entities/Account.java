package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.AccountStatus;
import com.clap.lms.domain.valueobjects.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public abstract class Account {
  private Integer accountId;
  private String password;
  private AccountStatus accountStatus;
  private Person person;
}
