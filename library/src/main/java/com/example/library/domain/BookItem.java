package com.example.library.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public class BookItem{
    private Integer bookItemId;

    private String barCode;

    private Book book;
}
