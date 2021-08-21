package com.example.library.service.impl;

import com.example.library.domain.Book;
import com.example.library.exception.BookUnavailableException;
import com.example.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookCatalog implements BookService {
    private List<Book> books = new ArrayList<>();

    private Map<Integer, Book> isbnToBookMap = new HashMap<>();

    @Override
    public Book getBookByTitle(String title) {
        return isbnToBookMap.get(title);
    }

    @Override
    public void addBook(Book book) {
        if (isbnToBookMap.get(book.getId()) == null) {
            isbnToBookMap.put(book.getId(), book);
            books.add(book);
        } else {
            throw new IllegalArgumentException("Book already exist with same ISBN");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    @Override
    public synchronized Book checkOut(Integer bookId) throws BookUnavailableException {
        Book book = isbnToBookMap.get(bookId);
        if (book.isAvailable()) {
            book.lend();
            return book;
        } else {
            throw new BookUnavailableException();
        }
    }

    @Override
    public synchronized void returnBook(Integer bookId) {
        Book book = isbnToBookMap.get(bookId);
        book.setIsAvailable(true);
    }

}
