package com.clap.lms.application.usecases;

import com.clap.lms.application.ports.BookCommand;
import com.clap.lms.application.ports.BookQuery;
import com.clap.lms.domain.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCatalogService implements BookCatalogUseCase {

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
  public List<Book> getAllBooks() {
    return bookQuery.getAllBooks();
  }

  @Override
  public synchronized Book checkOut(Integer bookId) {
    Book book = bookQuery.getBookById(bookId);
    //    if (book.isAvailable()) {
    //      book.lend();
    //      // Add due date and create record BookLendingRecord
    //      // Let new service scan the records for creating notification
    return book;
    //    } else {
    //      throw BookUnavailableException.couldNotIssueRequestedBook();
    //    }
  }

}
