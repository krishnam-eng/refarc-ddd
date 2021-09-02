package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookStatus;
import com.clap.lms.domain.enumerations.BookType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class BookItem {
  private Book book;

  private BookType bookType;

  private Integer bookItemId;

  private String barCode;

  private BookStatus bookStatus;

  void reserveBook(){
    bookStatus = BookStatus.RESERVED;
  }

  void markLost(){
    bookStatus = BookStatus.LOST;
  }

  boolean isAvailable() {
    return this.getBookStatus().equals(BookStatus.AVAILABLE);
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public BookType getBookType() {
    return bookType;
  }

  public void setBookType(BookType bookType) {
    this.bookType = bookType;
  }

  public Integer getBookItemId() {
    return bookItemId;
  }

  public void setBookItemId(Integer bookItemId) {
    this.bookItemId = bookItemId;
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
