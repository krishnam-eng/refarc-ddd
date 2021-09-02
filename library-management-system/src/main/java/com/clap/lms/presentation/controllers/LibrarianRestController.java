package com.clap.lms.presentation.controllers;

import com.clap.lms.application.usecases.BookCatalogUseCase;
import com.clap.lms.application.usecases.MembershipUseCase;
import com.clap.lms.domain.entities.Book;
import com.clap.lms.domain.entities.BookItem;
import com.clap.lms.domain.entities.MemberAccount;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/librarian")
public class LibrarianRestController {
  public static final Logger log = LoggerFactory.getLogger(LibrarianRestController.class);

  MembershipUseCase membershipService;
  BookCatalogUseCase bookCatalogService;

  public LibrarianRestController(
      MembershipUseCase membershipService, BookCatalogUseCase bookCatalogService) {
    this.membershipService = membershipService;
    this.bookCatalogService = bookCatalogService;
  }

  @PostMapping(path = "/membership/createMemberAccount")
  public void createMemberAccount(@Validated MemberAccount memberAccount) {
    try {
      membershipService.createMembership(memberAccount);
    } catch (IllegalStateException illegalStateException) {
      log.debug(ExceptionUtils.getStackTrace(illegalStateException));
      throw new ResponseStatusException(
          HttpStatus.CONFLICT, ExceptionUtils.getMessage(illegalStateException));
    }
  }

  @GetMapping(path = "/membership/fetchMemberDetail")
  public MemberAccount fetchMemberDetail(String memberId) {
    log.debug(memberId);
    return membershipService.fetchMemberDetails(memberId);
  }

  @GetMapping(path = "/membership/getAllMemberDetails")
  public List<MemberAccount> getAllMemberDetails() {
    return membershipService.getAllMemberDetails();
  }

  @PutMapping("/membership/blockMemberAccount")
  public MemberAccount blockMemberAccount(String memberId) {
    log.debug(memberId);
    return membershipService.blockMember(memberId);
  }

  @PutMapping("/membership/unblockMemberAccount")
  public MemberAccount unblockMemberAccount(String memberId) {
    log.debug(memberId);
    return membershipService.unblockMemberAccount(memberId);
  }

  @DeleteMapping("/membership/deleteMemberAccount")
  public void deleteMemberAccount(MemberAccount memberAccount) {
    log.debug(memberAccount.toString());
    throw new UnsupportedOperationException("FUNCTIONALITY_IS_NOT_IMPLEMENTED");
  }

  @PostMapping("/bookcatalog/addBookItem")
  public void addBookItem(BookItem bookItem) {
    try {
      bookCatalogService.addBookItem(bookItem);
    } catch (IllegalArgumentException illegalArgumentException) {
      log.debug(ExceptionUtils.getStackTrace(illegalArgumentException));
      throw new ResponseStatusException(
          HttpStatus.NOT_ACCEPTABLE, ExceptionUtils.getStackTrace(illegalArgumentException));
    }
  }

  @PostMapping("/bookcatalog/addBookMetadata")
  public void addBook(Book book) {
    try {
      bookCatalogService.addBook(book);
    } catch (IllegalArgumentException illegalArgumentException) {
      log.debug(ExceptionUtils.getStackTrace(illegalArgumentException));
      throw new ResponseStatusException(
              HttpStatus.NOT_ACCEPTABLE, ExceptionUtils.getStackTrace(illegalArgumentException));
    }
  }

  @GetMapping("/bookcatalog/getAllBookItems")
  public List<BookItem> getAllBookItems() {
    return bookCatalogService.getAllBookItems();
  }
}
