package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.domain.Member;
import com.example.library.service.BookService;
import com.example.library.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/librarian")
@Slf4j
public class LibrarianRestController {

    BookService bookService;
    MemberService memberService;

    public LibrarianRestController(BookService bookService, MemberService memberService) {
        this.bookService = bookService;
        this.memberService = memberService;
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // search catalog (we will have separate service for this - both
    @PostMapping("/addBook")
    public void addBook(@Validated Book book) {
        log.debug(book.toString());
        bookService.addBook(book);
    }

    @PatchMapping(path = "/updateBook")
    public void updateBookItem(Book book) {
        log.debug(book.toString());
        throw new UnsupportedOperationException("Functionality is not implemented");
    }

    @DeleteMapping(path = "/deleteBook")
    public void deleteBookItem(Book book) {
        log.debug(book.toString());
        throw new UnsupportedOperationException("Functionality is not implemented");
    }

    @PostMapping(path = "/createMemberAccount")
    public void createMemberAccount(Member memberAccount) {
        log.debug(memberAccount.toString());
        memberService.createMembership(memberAccount);
    }

    @GetMapping(path = "/getAllMembers")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("blockMemberAccount")
    public Member blockMemberAccount(Integer memberId) {
        log.debug(memberId.toString());
        return memberService.deactivateMember(memberId);
    }

    @DeleteMapping("deleteMemberAccount")
    public void deleteMemberAccount(Member memberAccount) {
        log.debug(memberAccount.toString());
        throw new UnsupportedOperationException("Functionality is not implemented");
    }

}
