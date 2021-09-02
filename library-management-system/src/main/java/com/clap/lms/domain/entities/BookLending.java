package com.clap.lms.domain.entities;

import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString
public class BookLending {
  @NotNull private final BookItem bookItem;

  @NotNull private final MemberAccount member;

  @NotNull private final LocalDate creationDate;

  @NotNull private final LocalDate dueDate;

  private LocalDate returnDate;

  public BookLending(BookItem bookItem, MemberAccount member, LocalDate creationDate, LocalDate dueDate) {
    this.bookItem = bookItem;
    this.member = member;
    this.creationDate = creationDate;
    this.dueDate = dueDate;
  }

  public BookItem getBookItem() {
    return bookItem;
  }

  public MemberAccount getMember() {
    return member;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

}
