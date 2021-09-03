package com.clap.lms.application.exceptions;

public class LMSException extends Exception {

  public LMSException(String message) {
    super(message);
  }

  public static LMSException couldNotIssueRequestedBook() {
    return new LMSException(
        "Could not issue a requested book due to its unavailability. Please try again later.");
  }

  public static LMSException couldNotIssueReferenceBook() {
    return new LMSException(
        "Could not issue a reference book. Please try non reference book");
  }

  public static LMSException couldNotIssueMoreThanAllowedBooks() {
    return new LMSException(
        " Could not issue additional books due to the upper limit. Return a holding book before checking out new book");
  }

  public static LMSException invalidMemberId() {
    return new LMSException(" Could not issue book for an invalid member id.");
  }

  public static LMSException invalidBookId() {
    return new LMSException(" Could not issue book for an invalid book code.");
  }

  public static LMSException withMessage(String message) {
    return new LMSException(message);
  }
}
