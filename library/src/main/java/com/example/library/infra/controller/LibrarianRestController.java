package com.example.library.infra.controller;

import com.example.library.domain.model.Book;
import com.example.library.domain.model.account.MemberAccount;
import com.example.library.domain.repository.BookLendingService;
import com.example.library.domain.repository.BookSearchService;
import com.example.library.domain.repository.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/librarian")
@Slf4j
public class LibrarianRestController {

    public static final String FUNCTIONALITY_IS_NOT_IMPLEMENTED = "Functionality is not implemented";
    BookLendingService bookLendingService;
    BookSearchService bookReaderService;
    MemberService memberService;

    public LibrarianRestController(BookLendingService bookLendingService, BookSearchService bookReaderService, MemberService memberService) {
        this.bookLendingService = bookLendingService;
        this.bookReaderService = bookReaderService;
        this.memberService = memberService;
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookReaderService.getAllBooks();
    }

    // search catalog (we will have separate service for this - both
    @PostMapping("/addBook")
    public void addBook(@Validated Book book) {
        log.debug(book.toString());
        bookLendingService.addBook(book);
    }

    @PatchMapping(path = "/updateBook")
    public void updateBookItem(Book book) {
        log.debug(book.toString());
        throw new UnsupportedOperationException(FUNCTIONALITY_IS_NOT_IMPLEMENTED);
    }

    @DeleteMapping(path = "/deleteBook")
    public void deleteBookItem(Book book) {
        log.debug(book.toString());
        throw new UnsupportedOperationException(FUNCTIONALITY_IS_NOT_IMPLEMENTED);
    }

    @PostMapping(path = "/createMemberAccount")
    public void createMemberAccount(@Validated MemberAccount memberAccount) {
        log.debug(memberAccount.toString());
        memberService.createMembership(memberAccount);
    }

    @GetMapping(path = "/getAllMembers")
    public List<MemberAccount> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("blockMemberAccount")
    public MemberAccount blockMemberAccount(Integer memberId) {
        log.debug(memberId.toString());
        return memberService.deactivateMember(memberId);
    }

    @DeleteMapping("deleteMemberAccount")
    public void deleteMemberAccount(MemberAccount memberAccount) {
        log.debug(memberAccount.toString());
        throw new UnsupportedOperationException(FUNCTIONALITY_IS_NOT_IMPLEMENTED);
    }

}
