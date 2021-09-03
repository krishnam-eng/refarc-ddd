package com.clap.lms.application.usecases.impl;

import com.clap.lms.application.exceptions.LMSException;
import com.clap.lms.application.usecases.BookCatalogService;
import com.clap.lms.application.usecases.BookLendingService;
import com.clap.lms.application.usecases.MemberService;
import com.clap.lms.application.usecases.MembershipService;
import com.clap.lms.domain.entities.BookItem;
import com.clap.lms.domain.entities.BookLending;
import com.clap.lms.domain.entities.MemberAccount;
import com.clap.lms.domain.enumerations.BookStatus;
import com.clap.lms.domain.properties.BusinessProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class MemberServiceImpl implements MemberService {

  private MembershipService membershipService;
  private BookCatalogService bookCatalogService;
  private BookLendingService bookLendingService;

  public MemberServiceImpl(
      MembershipService membershipService,
      BookCatalogService bookCatalogService,
      BookLendingService bookLendingService) {
    this.membershipService = membershipService;
    this.bookCatalogService = bookCatalogService;
    this.bookLendingService = bookLendingService;
  }

  /*
  Logic Flow:
    validation
    negative path
    happy path
   */

  @Override
  public BookLending checkOut(String memberId, String bookItemBarCode)
      throws LMSException {

    MemberAccount memberAccount = membershipService.getMemberDetail(memberId);

    if (memberAccount == null) {
      throw LMSException.invalidMemberId();
    }

    if (memberAccount.getTotalBooksCheckedOut() >= BusinessProperties.MAX_BOOKS_ALLOWED) {
      throw LMSException.couldNotIssueMoreThanAllowedBooks();
    }

    BookItem bookItem = bookCatalogService.getBookItemByBarCode(bookItemBarCode);

    if (bookItem == null) {
      throw LMSException.invalidBookId();
    }

    if (bookItem.isReferenceOnly()) {
      throw LMSException.couldNotIssueReferenceBook();
    }

    if (!bookItem.isAvailable()) {
      throw LMSException.couldNotIssueRequestedBook();
    }

    LocalDate creationDate = LocalDate.now();
    LocalDate dueDate = LocalDate.now().plusDays(BusinessProperties.MAX_BOOK_HOLDING_DAYS);

    BookLending bookLending = new BookLending(bookItem, memberAccount, creationDate, dueDate);
    bookLendingService.createBookLendingRecord(bookLending);
    bookItem.setBookStatus(BookStatus.LOANED);
    memberAccount.setTotalBooksCheckedOut((short) (memberAccount.getTotalBooksCheckedOut() + 1));

    return bookLending;
  }

  @Override
  public BookLending returnBook(String memberId, String bookItemBarCode) throws LMSException {

    MemberAccount memberAccount = membershipService.getMemberDetail(memberId);
    if (memberAccount == null) {
      throw LMSException.invalidMemberId();
    }

    BookItem bookItem = bookCatalogService.getBookItemByBarCode(bookItemBarCode);
    if (bookItem == null) {
      throw LMSException.invalidBookId();
    }

    BookLending bookLending = bookLendingService.fetchBookLeadingRecord(bookItem.getBarCode());
    if (bookLending == null) {
      throw LMSException.withMessage("Invalid record of book lending");
    }

    LocalDate returnDate = LocalDate.now();
    bookLending.setReturnDate(returnDate);
    if(returnDate.isAfter(bookLending.getDueDate())){
      Period period = returnDate.until(bookLending.getDueDate());
      Long fine = period.getDays() * 10L;
      memberAccount.addFineAmount(fine);
    }

    bookItem.setBookStatus(BookStatus.AVAILABLE);
    memberAccount.setTotalBooksCheckedOut((short)(memberAccount.getTotalBooksCheckedOut()-1));

    return bookLending;
  }

  @Override
  public BookLending renewBook(String memberId, String bookItemBarCode) {
    return null;
  }
}
