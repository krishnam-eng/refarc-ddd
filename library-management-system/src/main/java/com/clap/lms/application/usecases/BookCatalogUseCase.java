package com.clap.lms.application.usecases;

import com.clap.lms.domain.entities.Book;
import com.clap.lms.domain.entities.BookItem;

import java.util.List;

public interface BookCatalogUseCase {
  void addBookItem(BookItem bookItem);

  BookItem getBookItemByBarCode(String barCode);

  List<BookItem> getAllBookItems();

  List<BookItem> getAllAvailableBooks();

  void addBook(Book book);
}
