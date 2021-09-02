package com.clap.lms.application.usecases.impl;

import com.clap.lms.application.usecases.BookCatalogService;
import com.clap.lms.domain.entities.Book;
import com.clap.lms.domain.entities.BookItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookCatalogServiceImpl implements BookCatalogService {

  // These data will be moved to persistence layer with cache aside model
  List<BookItem> bookItems = new ArrayList<>();
  Map<String, BookItem> bookItemMap = new HashMap<>();
  List<Book> books = new ArrayList<>();
  Map<String, Book> indexedBooks = new HashMap<>();

  @Override
  public void addBook(Book book) {
    if (indexedBooks.get(book.getIsbnCode()) == null) {
      indexedBooks.put(book.getIsbnCode(), book);
      books.add(book);
    } else {
      throw new IllegalArgumentException("Book already exist with same IsbnCode");
    }
  }

  @Override
  public void addBookItem(BookItem bookItem) {
    if (bookItemMap.get(bookItem.getBarCode()) == null) {
      bookItemMap.put(bookItem.getBarCode(), bookItem);
      bookItems.add(bookItem);
    } else {
      throw new IllegalArgumentException("Book already exist with same BarCode");
    }
  }

  @Override
  public BookItem getBookItemByBarCode(String barCode) {
    return bookItemMap.get(barCode);
  }

  @Override
  public List<BookItem> getAllBookItems() {
    return bookItems;
  }

  @Override
  public List<BookItem> getAllAvailableBooks() {
    return bookItems.stream().filter(BookItem::isAvailable).collect(Collectors.toList());
  }

}
