package com.example.library.service.impl;

import com.example.library.model.entity.Book;
import com.example.library.exception.BookUnavailableException;
import com.example.library.service.BookManagementService;
import com.example.library.service.BookReaderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class BookCatalogService implements BookManagementService, BookReaderService{
    private final List<Book> books = new CopyOnWriteArrayList<>();

    private final Map<Integer, Book> isbnToBookMap = new HashMap<>();

    @Override
    public Book getBookById(Integer title) {
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
    public Book checkOut(Integer bookId) throws BookUnavailableException {
        Book book = isbnToBookMap.get(bookId);
        synchronized (book) {
            if (book.isAvailable()) {
                book.lend();
                return book;
            } else {
                throw new BookUnavailableException();
            }
        }
    }

    @Override
    public void returnBook(Integer bookId) {
        Book book = isbnToBookMap.get(bookId);
        synchronized (book) {
            book.setAvailable(true);
        }
    }
}
