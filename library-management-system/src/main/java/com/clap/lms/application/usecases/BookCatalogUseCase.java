package com.clap.lms.application.usecases;

import com.clap.lms.domain.entities.Book;

import java.util.List;

public interface BookCatalogUseCase {
  void addBook(Book book);

  List<Book> getAllBooks();

  Book checkOut(Integer bookId);

}
