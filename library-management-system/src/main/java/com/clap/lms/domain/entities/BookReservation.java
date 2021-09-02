package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.BookReservationStatus;

import java.util.Date;

public class BookReservation {
    private BookItem bookItem;
    private MemberAccount member;
    private Date reservationDate;
    private BookReservationStatus bookReservationStatus = BookReservationStatus.NONE;

    public BookReservation(BookItem bookItem, MemberAccount member, Date reservationDate) {
        this.bookItem = bookItem;
        this.member = member;
        this.reservationDate = reservationDate;
    }

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

    public BookItem getBookItem() {
        return bookItem;
    }

    public MemberAccount getMember() {
        return member;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public BookReservationStatus getBookReservationStatus() {
        return bookReservationStatus;
    }

    // Use case:
    //  fetch reservation details by book code
}
