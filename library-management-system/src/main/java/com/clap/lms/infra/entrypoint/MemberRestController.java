package com.clap.lms.infra.entrypoint;

import com.clap.lms.business.exception.BookUnavailableException;
import com.clap.lms.business.service.BookCatalogService;
import com.clap.lms.domain.model.Book;
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
    public void returnBook(Integer bookId){
        bookService.returnBook(bookId);
    }

}
