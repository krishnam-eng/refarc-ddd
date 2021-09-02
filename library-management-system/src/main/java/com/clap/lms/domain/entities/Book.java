package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookType;
import com.clap.lms.domain.valueobjects.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;

@ToString
@Getter
@Setter
public class Book {
  @Size(max = 20)
  @NotNull private String isbnCode;

  @NotNull private String title;

  @NotNull private String subject;

  private Short numberOfPages;

  private String author;

  private Short publishedYear;

  @Size(max = 5)
  private List<Tag> tags;
}
