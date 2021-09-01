package com.example.library.business.repository;

import com.example.library.domain.model.Book;

public interface BookCommand {
    public void addBook(Book book);
    public void updateBookAvailability(Integer bookId, Boolean isAvailable);
}
