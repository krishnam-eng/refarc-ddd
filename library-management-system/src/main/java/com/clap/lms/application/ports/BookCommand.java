package com.clap.lms.application.ports;

import com.clap.lms.domain.entities.Book;

public interface BookCommand {
    void addBook(Book book);
    void updateBookAvailability(Integer bookId, Boolean isAvailable);
}
