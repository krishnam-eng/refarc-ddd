package com.example.library.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Address {
    private String country;
    private String state;
    private String city;
    private String street;
    private String door;
}
