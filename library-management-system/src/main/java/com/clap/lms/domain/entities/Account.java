package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.AccountStatus;
import com.clap.lms.domain.valueobjects.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public abstract class Account {
  // this is the username for the account
  private String accountId;
  private String password;
  private AccountStatus accountStatus;
  private Person person;

  void resetPassword(String password) {
    this.password = password;
  }
}
