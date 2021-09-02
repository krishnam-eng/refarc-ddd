package com.clap.lms.domain.entities;

import com.clap.lms.domain.valueobjects.Tag;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

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

  public String getIsbnCode() {
    return isbnCode;
  }

  public void setIsbnCode(String isbnCode) {
    this.isbnCode = isbnCode;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Short getNumberOfPages() {
    return numberOfPages;
  }

  public void setNumberOfPages(Short numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Short getPublishedYear() {
    return publishedYear;
  }

  public void setPublishedYear(Short publishedYear) {
    this.publishedYear = publishedYear;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }
}
