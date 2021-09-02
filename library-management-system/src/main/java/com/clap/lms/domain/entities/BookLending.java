package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookStatus;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
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

  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
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

  // Use cases:
  //  fetch lending details by book barcode
}
