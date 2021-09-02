package com.clap.lms.domain.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public final class Author {
  private final String name;
  private final Long authorId;

  public Author(String name, Long authorId) {
    this.name = name;
    this.authorId = authorId;
  }
}
