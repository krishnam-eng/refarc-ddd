package com.example.library.model.value;

import com.example.library.model.value.Address;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
public final class Person {
    private final String name;
    private final Address address;

    @NotNull
    private final String phone;

    @Email
    private final String email;

    public Person(String name, Address address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}
