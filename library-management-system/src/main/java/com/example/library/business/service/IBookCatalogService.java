package com.example.library.business.service;

import com.example.library.domain.model.Book;

import java.util.List;

public interface IBookCatalogService {
    void addBook(Book book);

    List<Book> getAllAvailableBooks();

    Book checkOut(Integer bookId);

    void returnBook(Integer bookId);
}
