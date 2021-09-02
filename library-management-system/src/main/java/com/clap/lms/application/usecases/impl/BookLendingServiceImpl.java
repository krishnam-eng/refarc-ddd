package com.clap.lms.application.usecases.impl;

import com.clap.lms.application.usecases.BookLendingService;
import com.clap.lms.domain.entities.BookLending;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookLendingServiceImpl implements BookLendingService {
  List<BookLending> bookLendingRecords = new ArrayList<>();
  Map<String, BookLending> bookLendingByBarCodeKey = new HashMap<>();
  Map<String, List<BookLending>> bookLendingsByMemberId = new HashMap<>();

  @Override
  public void createBookLendingRecord(BookLending bookLending) {
    bookLendingRecords.add(bookLending);
    bookLendingByBarCodeKey.put(bookLending.getBookItem().getBarCode(), bookLending);

    if (bookLendingsByMemberId.get(bookLending.getMember().getAccountId()) == null) {
      bookLendingsByMemberId.put(bookLending.getMember().getAccountId(), new ArrayList<>());
    }
    bookLendingsByMemberId.get(bookLending.getMember().getAccountId()).add(bookLending);
  }

  @Override
  public BookLending fetchBookLeadingRecord(String bookItemBarCode) {
    return bookLendingByBarCodeKey.get(bookItemBarCode);
  }

  @Override
  public List<BookLending> fetchBookLeadingRecordsByMember(String memberId) {
    return bookLendingsByMemberId.get(memberId);
  }
}
