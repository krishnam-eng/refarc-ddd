package com.clap.lms.business.repository;

import com.clap.lms.domain.model.Book;

public interface BookCommand {
    void addBook(Book book);
    void updateBookAvailability(Integer bookId, Boolean isAvailable);
}
