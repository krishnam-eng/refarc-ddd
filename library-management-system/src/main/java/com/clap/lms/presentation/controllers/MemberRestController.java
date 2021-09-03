package com.clap.lms.presentation.controllers;

import com.clap.lms.application.exceptions.LMSException;
import com.clap.lms.application.usecases.BookLendingService;
import com.clap.lms.application.usecases.MemberService;
import com.clap.lms.domain.entities.BookLending;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {
  public static final Logger LOG = LoggerFactory.getLogger(MemberRestController.class);

  MemberService memberService;
  BookLendingService bookLendingService;

  public MemberRestController(MemberService memberService, BookLendingService bookLendingService) {
    this.memberService = memberService;
    this.bookLendingService = bookLendingService;
  }

  @PostMapping("/checkOut")
  public BookLending checkOut(String memberId, String bookItemBarCode) {
    BookLending bookLending;
    try {
      bookLending = memberService.checkOut(memberId, bookItemBarCode);
    } catch (LMSException lmsException) {
      LOG.debug(ExceptionUtils.getStackTrace(lmsException));
      throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    return bookLending;
  }

  @GetMapping("/getLendingRecords")
  public List<BookLending> getLendingRecords(String memberId) {
    return bookLendingService.fetchBookLeadingRecordsByMember(memberId);
  }

  @PutMapping("/returnBook")
  public BookLending returnBook(String memberId, String bookItemBarCode) {
    try {
      return memberService.returnBook(memberId, bookItemBarCode);
    } catch (LMSException lmsException) {
      LOG.debug(ExceptionUtils.getStackTrace(lmsException));
      throw new ResponseStatusException(HttpStatus.NOT_MODIFIED);
    }
  }
}
