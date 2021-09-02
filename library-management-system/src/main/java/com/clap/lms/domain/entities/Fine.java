package com.clap.lms.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Fine {
  private BookItem bookItem;
  private MemberAccount member;
  private Integer amount;

  public Fine(BookItem bookItem, MemberAccount member, Integer amount) {
    this.bookItem = bookItem;
    this.member = member;
  }

  // Use cases:
  // compute fine
  // settle fine
}
