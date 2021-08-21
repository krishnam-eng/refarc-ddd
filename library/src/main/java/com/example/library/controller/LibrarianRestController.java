package com.example.library.controller;

import com.example.library.model.domain.Book;
import com.example.library.model.user.MemberAccount;
import com.example.library.service.BookManagementService;
import com.example.library.service.BookReaderService;
import com.example.library.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/librarian")
@Slf4j
public class LibrarianRestController {

    public static final String FUNCTIONALITY_IS_NOT_IMPLEMENTED = "Functionality is not implemented";
    BookManagementService bookManagementService;
    BookReaderService bookReaderService;
    MemberService memberService;

    public LibrarianRestController(BookManagementService bookManagementService, BookReaderService bookReaderService, MemberService memberService) {
        this.bookManagementService = bookManagementService;
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
        bookManagementService.addBook(book);
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
