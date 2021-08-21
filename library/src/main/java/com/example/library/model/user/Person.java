package com.example.library.model.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Person {
    private String name;
    private Address address;

    @NotNull
    private String phone;

    @Email
    private String email;
}
