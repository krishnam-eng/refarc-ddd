package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookReservationStatus;

import java.util.Date;

public class BookReservation {
    private BookItem bookItem;
    private MemberAccount member;
    private Date reservationDate;
    private BookReservationStatus bookReservationStatus = BookReservationStatus.NONE;

    BookReservationStatus reserveBook(){
        if (bookItem.isAvailable()){
            bookReservationStatus = BookReservationStatus.RESERVED;
        } else {
            bookReservationStatus = BookReservationStatus.WAITING;
        }
        return bookReservationStatus;
    }

    void cancelReservation(){
        bookReservationStatus = BookReservationStatus.CANCELED;
    }

    // Use case:
    //  fetch reservation details by book code
}
