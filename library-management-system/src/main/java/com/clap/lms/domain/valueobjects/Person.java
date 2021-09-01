package com.clap.lms.domain.valueobjects;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@ToString
public final class Person {
  private final String name;
  private final Address address;

  @NotNull private final String phone;

  @Email private final String email;

  public Person(String name, Address address, String phone, String email) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }
}
