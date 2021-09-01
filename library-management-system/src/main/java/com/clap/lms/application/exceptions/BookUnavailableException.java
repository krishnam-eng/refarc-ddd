package com.clap.lms.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class BookUnavailableException extends RuntimeException {

    public BookUnavailableException(String message) {
        super(message);
    }

    public static BookUnavailableException couldNotIssueRequestedBook() {
        return new BookUnavailableException("Could not issue a requested book due to its unavailability. Please try again later.");
    }
}
