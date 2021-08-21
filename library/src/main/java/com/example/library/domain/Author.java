package com.example.library.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Author {
    private String name;
    private Long authorId;
    // other meta data
}
