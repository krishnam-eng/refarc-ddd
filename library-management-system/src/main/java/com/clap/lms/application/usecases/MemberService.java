package com.clap.lms.application.usecases;

import com.clap.lms.application.exceptions.BookCheckoutException;
import com.clap.lms.domain.entities.BookLending;

public interface MemberService {
  BookLending checkOut(String memberId, String bookItemBarCode) throws BookCheckoutException;

  void returnBook(String memberId, String bookItemBarCode);

  BookLending renewBook(String memberId, String bookItemBarCode);
}
