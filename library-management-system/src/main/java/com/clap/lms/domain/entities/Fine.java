package com.clap.lms.domain.entities;

public final class Fine {
  private BookItem bookItem;
  private MemberAccount member;
  private Integer amount;

  public Fine(BookItem bookItem, MemberAccount member, Integer amount) {
    this.bookItem = bookItem;
    this.member = member;
    this.amount = amount;
  }

  public BookItem getBookItem() {
    return bookItem;
  }

  public MemberAccount getMember() {
    return member;
  }

  public Integer getAmount() {
    return amount;
  }

  // Use cases:
  // compute fine
  // settle fine
}
