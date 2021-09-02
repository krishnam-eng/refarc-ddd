package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookStatus;
import lombok.ToString;

@ToString
public class BookItem {
  private String barCode;

  private String bookIsbnCode;

  private boolean referenceOnly;

  private BookStatus bookStatus;

  void reserveBook() {
    bookStatus = BookStatus.RESERVED;
  }

  void markLost() {
    bookStatus = BookStatus.LOST;
  }

  public boolean isAvailable() {
    return this.getBookStatus().equals(BookStatus.AVAILABLE);
  }

  public void setBookIsbnCode(String bookIsbnCode) {
    this.bookIsbnCode = bookIsbnCode;
  }

  public String getBookIsbnCode() {
    return bookIsbnCode;
  }

  public boolean isReferenceOnly() {
    return referenceOnly;
  }

  public void setReferenceOnly(boolean referenceOnly) {
    this.referenceOnly = referenceOnly;
  }

  public String getBarCode() {
    return barCode;
  }

  public void setBarCode(String barCode) {
    this.barCode = barCode;
  }

  public BookStatus getBookStatus() {
    return bookStatus;
  }

  public void setBookStatus(BookStatus bookStatus) {
    this.bookStatus = bookStatus;
  }
}
