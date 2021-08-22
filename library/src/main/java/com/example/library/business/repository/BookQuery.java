package com.example.library.business.repository;

import com.example.library.domain.model.Book;

import java.util.List;

public interface BookQuery {
    Book getBookById(Integer title);

    public List<Book> getAllBooks();

    public List<Book> getAllAvailableBooks();

}
