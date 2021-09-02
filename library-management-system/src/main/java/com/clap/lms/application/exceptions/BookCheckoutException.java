package com.clap.lms.application.exceptions;

public class BookCheckoutException extends Exception {

  public BookCheckoutException(String message) {
    super(message);
  }

  public static BookCheckoutException couldNotIssueRequestedBook() {
    return new BookCheckoutException(
        "Could not issue a requested book due to its unavailability. Please try again later.");
  }

  public static BookCheckoutException couldNotIssueReferenceBook() {
    return new BookCheckoutException(
        "Could not issue a reference book. Please try non reference book");
  }

  public static BookCheckoutException couldNotIssueMoreThanAllowedBooks() {
    return new BookCheckoutException(
        " Could not issue additional books due to the upper limit. Return a holding book before checking out new book");
  }

  public static BookCheckoutException invalidMemberId() {
    return new BookCheckoutException(" Could not issue book for an invalid member id.");
  }

  public static BookCheckoutException invalidBookId() {
    return new BookCheckoutException(" Could not issue book for an invalid book code.");
  }
}
