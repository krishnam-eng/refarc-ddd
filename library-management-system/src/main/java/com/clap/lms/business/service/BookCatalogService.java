package com.clap.lms.business.service;

import com.clap.lms.business.exception.BookUnavailableException;
import com.clap.lms.business.repository.BookCommand;
import com.clap.lms.business.repository.BookQuery;
import com.clap.lms.domain.model.Book;
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
  public synchronized Book checkOut(Integer bookId) {
    Book book = bookQuery.getBookById(bookId);
    if (book.isAvailable()) {
      book.lend();
      // Add due date and create record BookLendingRecord
      // Let new service scan the records for creating notification
      return book;
    } else {
      throw BookUnavailableException.couldNotIssueRequestedBook();
    }
  }

  @Override
  public void returnBook(Integer bookId) {
    bookCommand.updateBookAvailability(bookId, Boolean.TRUE);
  }
}
