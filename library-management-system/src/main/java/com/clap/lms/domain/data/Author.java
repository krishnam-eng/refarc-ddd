package com.clap.lms.domain.data;

import lombok.Getter;
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