package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.AccountStatus;
import com.clap.lms.domain.valueobjects.Person;

public abstract class Account {
  // this is the username for the account
  private String accountId;
  private String password;
  private AccountStatus accountStatus;
  private Person person;

  void resetPassword(String password) {
    this.password = password;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AccountStatus getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(AccountStatus accountStatus) {
    this.accountStatus = accountStatus;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
