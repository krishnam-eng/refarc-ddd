package com.example.library.domain.repository;

import com.example.library.domain.model.Book;

import java.util.List;

public interface BookSearchService {
    Book getBookById(Integer title);

    public List<Book> getAllBooks();

    public List<Book> getAllAvailableBooks();

}
