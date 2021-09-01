package com.clap.lms.application.ports;

import com.clap.lms.domain.entities.Book;

import java.util.List;

public interface BookQuery {
  Book getBookById(Integer title);

  List<Book> getAllBooks();

  List<Book> getAllAvailableBooks();
}
