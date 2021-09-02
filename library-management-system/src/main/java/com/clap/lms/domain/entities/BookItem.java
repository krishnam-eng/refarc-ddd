package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookStatus;
import com.clap.lms.domain.enumerations.BookType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
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
}
