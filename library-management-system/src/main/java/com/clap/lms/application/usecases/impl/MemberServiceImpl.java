package com.clap.lms.application.usecases.impl;

import com.clap.lms.application.exceptions.BookCheckoutException;
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

@Service
public class MemberServiceImpl implements MemberService {

  private MembershipService membershipService;
  private BookCatalogService bookCatalogService;
  private BookLendingService bookLendingService;

  public MemberServiceImpl(MembershipService membershipService, BookCatalogService bookCatalogService, BookLendingService bookLendingService) {
    this.membershipService = membershipService;
    this.bookCatalogService = bookCatalogService;
    this.bookLendingService = bookLendingService;
  }

  @Override
  public BookLending checkOut(String memberId, String bookItemBarCode)
      throws BookCheckoutException {

    MemberAccount memberAccount = membershipService.getMemberDetail(memberId);

    if (memberAccount == null){
      throw BookCheckoutException.invalidMemberId();
    }

    if (memberAccount.getTotalBooksCheckedOut() >= BusinessProperties.MAX_BOOKS_ALLOWED) {
      throw BookCheckoutException.couldNotIssueMoreThanAllowedBooks();
    }

    BookItem bookItem = bookCatalogService.getBookItemByBarCode(bookItemBarCode);

    if (bookItem == null){
      throw BookCheckoutException.invalidBookId();
    }

    if (bookItem.isReferenceOnly()) {
      throw BookCheckoutException.couldNotIssueReferenceBook();
    }

    if (!bookItem.isAvailable()) {
      throw BookCheckoutException.couldNotIssueRequestedBook();
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
  public void returnBook(String memberId, String bookItemBarCode) {}

  @Override
  public BookLending renewBook(String memberId, String bookItemBarCode) {
    return null;
  }
}
