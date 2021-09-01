package com.clap.lms.domain.valueobjects;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Tag {
  private final String tagName;

  public Tag(String tagName) {
    this.tagName = tagName;
  }
}
