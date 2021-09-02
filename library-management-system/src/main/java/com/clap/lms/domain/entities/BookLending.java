package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookStatus;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
public class BookLending {
  @NotNull private final BookItem bookItem;

  @NotNull private final MemberAccount member;

  @NotNull private final Date creationDate;

  @NotNull private final Date dueDate;

  private Date returnDate;

  public BookLending(BookItem bookItem, MemberAccount member, Date creationDate, Date dueDate) {
    this.bookItem = bookItem;
    this.member = member;
    this.creationDate = creationDate;
    this.dueDate = dueDate;
  }

  boolean lendBook() {
    if (bookItem.isAvailable()) {
      bookItem.setBookStatus(BookStatus.LOANED);
      return true;
    }
    return false;
  }

  void returnBook() {
    bookItem.setBookStatus(BookStatus.AVAILABLE);
  }

  public BookItem getBookItem() {
    return bookItem;
  }

  public MemberAccount getMember() {
    return member;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public Date getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }

  // Use cases:
  //  fetch lending details by book barcode
}
