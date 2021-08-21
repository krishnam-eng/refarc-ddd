package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.exception.BookUnavailableException;
import com.example.library.service.BookService;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

    BookService bookService;

    public MemberRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/checkOut")
    public Book checkOut(Integer bookId) throws BookUnavailableException {
        return bookService.checkOut(bookId);
    }

    @GetMapping("/returnBook")
    public void returnBook(Integer bookId){
        bookService.returnBook(bookId);
    }

}
