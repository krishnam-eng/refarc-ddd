package com.example.library.business.service;

import com.example.library.domain.model.Book;
import com.example.library.business.exception.BookUnavailableException;
import com.example.library.business.repository.BookCommand;
import com.example.library.business.repository.BookQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCatalogService implements IBookCatalogService {

    BookCommand bookCommand;

    BookQuery bookQuery;

    public BookCatalogService(BookCommand bookCommand, BookQuery bookQuery) {
        this.bookCommand = bookCommand;
        this.bookQuery = bookQuery;
    }

    @Override
    public void addBook(Book book) {
        bookCommand.addBook(book);
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        return bookQuery.getAllBooks().stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    @Override
    public Book checkOut(Integer bookId) {
        Book book = bookQuery.getBookById(bookId);
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
        bookCommand.updateBookAvailability(bookId, Boolean.TRUE);
    }
}
