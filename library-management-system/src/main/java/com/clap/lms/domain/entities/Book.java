package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

@ToString
@Getter
@Setter
public class Book {
  @NotNull private Integer bookId;

  @NotNull private String title;

  @NotNull private String isbnCode;

  @NotNull
  @Max(10_000)
  private Short numberOfPages;

  @Null private BookType bookType;

  @Null private String author;

  private boolean isAvailable;

  private Short publishedYear;

  private String subject;

  @Size(max = 5)
  private List<String> tags;

  public boolean isAvailable() {
    return isAvailable;
  }

  public void lend() {
    isAvailable = false;
  }
}
