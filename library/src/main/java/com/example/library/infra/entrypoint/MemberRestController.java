package com.example.library.infra.entrypoint;

import com.example.library.business.exception.BookUnavailableException;
import com.example.library.domain.model.Book;
import com.example.library.business.repository.BookCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

    BookCommand bookService;

    public MemberRestController(BookCommand bookService) {
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
