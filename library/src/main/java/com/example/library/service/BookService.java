package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.exception.BookUnavailableException;

import java.util.List;

public interface BookService {
    Book getBookByTitle(String title);

    public void addBook(Book book);

    public List<Book> getAllBooks();

    public List<Book> getAllAvailableBooks();
    public Book checkOut(Integer bookId) throws BookUnavailableException;

    public void returnBook(Integer bookId);
}
