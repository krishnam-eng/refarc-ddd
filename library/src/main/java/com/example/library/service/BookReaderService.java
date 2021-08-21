package com.example.library.service;

import com.example.library.model.domain.Book;

import java.util.List;

public interface BookReaderService{
    Book getBookById(Integer title);

    public List<Book> getAllBooks();

    public List<Book> getAllAvailableBooks();

}
