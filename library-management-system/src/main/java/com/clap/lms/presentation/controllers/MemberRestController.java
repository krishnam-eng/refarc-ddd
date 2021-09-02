package com.clap.lms.presentation.controllers;

import com.clap.lms.application.exceptions.BookUnavailableException;
import com.clap.lms.application.usecases.BookCatalogService;
import com.clap.lms.domain.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

  BookCatalogService bookService;

  public MemberRestController(BookCatalogService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/checkOut")
  public Book checkOut(Integer bookId) throws BookUnavailableException {
    return bookService.checkOut(bookId);
  }

  @GetMapping("/returnBook")
  public void returnBook(Integer bookId) {
    //bookService.returnBook(bookId);
  }
}
