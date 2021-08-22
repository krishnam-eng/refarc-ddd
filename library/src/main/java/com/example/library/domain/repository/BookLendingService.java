package com.example.library.domain.repository;

import com.example.library.domain.model.Book;

public interface BookLendingService {
    Book checkOut(Integer bookId);

    void returnBook(Integer bookId);

    public void addBook(Book book);

}
