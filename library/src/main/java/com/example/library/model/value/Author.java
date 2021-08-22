package com.example.library.model.value;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public final class Author {
    private final String name;
    private final Long authorId;

    public Author(String name, Long authorId) {
        this.name = name;
        this.authorId = authorId;
    }
}
