package com.clap.lms.presentation.controllers;

import com.clap.lms.application.ports.BookQuery;
import com.clap.lms.application.ports.MemberRepo;
import com.clap.lms.application.usecases.BookCatalogUseCase;
import com.clap.lms.domain.entities.Book;
import com.clap.lms.domain.entities.MemberAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/librarian")
@Slf4j
public class LibrarianRestController {

  public static final String FUNCTIONALITY_IS_NOT_IMPLEMENTED = "Functionality is not implemented";
  BookCatalogUseCase bookCatalogService;
  BookQuery bookReaderService;
  MemberRepo memberRepo;

  public LibrarianRestController(
      BookCatalogUseCase bookCatalogService, BookQuery bookReaderService, MemberRepo memberRepo) {
    this.bookCatalogService = bookCatalogService;
    this.bookReaderService = bookReaderService;
    this.memberRepo = memberRepo;
  }

  @GetMapping("/getAllBooks")
  public List<Book> getAllBooks() {
    return bookReaderService.getAllBooks();
  }

  // search catalog (we will have separate service for this - both
  @PostMapping("/addBook")
  public void addBook(@Validated Book book) {
    log.debug(book.toString());
    bookCatalogService.addBook(book);
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
    memberRepo.createMembership(memberAccount);
  }

  @GetMapping(path = "/getAllMembers")
  public List<MemberAccount> getAllMembers() {
    return memberRepo.getAllMembers();
  }

  @GetMapping("blockMemberAccount")
  public MemberAccount blockMemberAccount(Integer memberId) {
    log.debug(memberId.toString());
    return memberRepo.deactivateMember(memberId);
  }

  @DeleteMapping("deleteMemberAccount")
  public void deleteMemberAccount(MemberAccount memberAccount) {
    log.debug(memberAccount.toString());
    throw new UnsupportedOperationException(FUNCTIONALITY_IS_NOT_IMPLEMENTED);
  }
}
