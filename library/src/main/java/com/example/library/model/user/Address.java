package com.example.library.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class Address {
    private String country;
    private String state;
    private String city;
    private String street;
    private String door;

    @NotNull
    private String zipCode;
}
