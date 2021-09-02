package com.clap.lms.presentation.controllers;

import com.clap.lms.application.exceptions.BookCheckoutException;
import com.clap.lms.application.usecases.BookLendingService;
import com.clap.lms.application.usecases.MemberService;
import com.clap.lms.domain.entities.BookLending;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

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
    } catch (BookCheckoutException e) {
      throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    return bookLending;
  }

  @GetMapping("/getLendingRecords")
  public List<BookLending> getLendingRecords(String memberId){
    return bookLendingService.fetchBookLeadingRecordsByMember(memberId);
  }
}
