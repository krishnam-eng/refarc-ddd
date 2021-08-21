package com.example.library.service;

import com.example.library.exception.BookUnavailableException;
import com.example.library.model.domain.Book;

public interface BookManagementService{
    Book checkOut(Integer bookId) throws BookUnavailableException;

    void returnBook(Integer bookId);

    public void addBook(Book book);

}
