package com.clap.lms.domain.valueobjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@ToString
@EqualsAndHashCode
public final class Tag {

  @NotBlank
  @NotEmpty
  @Size(max = 10)
  private final String tagName;

  public Tag(String tagName) {
    this.tagName = tagName;
  }
}
