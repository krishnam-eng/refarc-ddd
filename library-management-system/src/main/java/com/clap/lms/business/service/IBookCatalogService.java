package com.clap.lms.business.service;

import com.clap.lms.domain.model.Book;

import java.util.List;

public interface IBookCatalogService {
    void addBook(Book book);

    List<Book> getAllAvailableBooks();

    Book checkOut(Integer bookId);

    void returnBook(Integer bookId);
}
