package com.clap.lms.business.repository;

import com.clap.lms.domain.model.Book;

import java.util.List;

public interface BookQuery {
    Book getBookById(Integer title);

    List<Book> getAllBooks();

    List<Book> getAllAvailableBooks();

}
