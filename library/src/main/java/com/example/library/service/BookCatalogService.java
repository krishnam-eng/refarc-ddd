package com.example.library.service;

import com.example.library.domain.model.Book;
import com.example.library.service.exception.BookUnavailableException;
import com.example.library.domain.repository.BookLendingService;
import com.example.library.domain.repository.BookSearchService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class BookCatalogService implements BookLendingService, BookSearchService {
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
    public Book checkOut(Integer bookId){
        Book book = isbnToBookMap.get(bookId);
        synchronized (book) {
            if (book.isAvailable()) {
                book.lend();
                // Add due date and create record BookLendingRecord
                // Let new service scan the records for creating notification
                return book;
            } else {
                throw BookUnavailableException.couldNotIssueRequestedBook();
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
