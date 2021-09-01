package com.clap.lms.domain.valueobjects;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Fine {
  private final Integer amount;

  public Fine(Integer amount) {
    this.amount = amount;
  }
}
