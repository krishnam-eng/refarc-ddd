package com.clap.lms.application.usecases;

import com.clap.lms.domain.entities.BookLending;

import java.util.List;

public interface BookLendingService {

    void createBookLendingRecord(BookLending bookLending);

    BookLending fetchBookLeadingRecord(String bookItemBarCode);

    List<BookLending> fetchBookLeadingRecordsByMember(String memberId);
}
