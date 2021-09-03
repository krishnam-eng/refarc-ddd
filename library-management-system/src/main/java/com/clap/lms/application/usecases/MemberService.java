package com.clap.lms.application.usecases;

import com.clap.lms.application.exceptions.LMSException;
import com.clap.lms.domain.entities.BookLending;

public interface MemberService {
  BookLending checkOut(String memberId, String bookItemBarCode) throws LMSException;

  BookLending returnBook(String memberId, String bookItemBarCode) throws LMSException;

  BookLending renewBook(String memberId, String bookItemBarCode);
}
