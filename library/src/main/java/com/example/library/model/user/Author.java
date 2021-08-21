package com.example.library.model.user;

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
