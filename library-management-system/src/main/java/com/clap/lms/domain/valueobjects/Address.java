package com.clap.lms.domain.valueobjects;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
// Make the value object immutable
public final class Address {
  // property can't be changed after object creation
  private final String country;
  private final String state;
  private final String city;
  private final String street;
  private final String door;
  private final String zipCode;

  private Address(
      String country, String state, String city, String street, String door, String zipCode) {
    this.country = country;
    this.state = state;
    this.city = city;
    this.street = street;
    this.door = door;
    this.zipCode = zipCode;
  }

  public static Address of(
      String country, String state, String city, String street, String door, String zipCode) {
    return new Address(country, state, city, street, door, zipCode);
  }
}
