package com.clap.lms.domain.entities;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString(callSuper = true)
public class MemberAccount extends Account {
  private Date dateOfMembership;

  private Short totalBooksCheckedOut;

  private Long fineAmount = 0L;

  public Long getFineAmount() {
    return fineAmount;
  }

  public void addFineAmount(Long fineAmount) {
    this.fineAmount += fineAmount;
  }

  public Date getDateOfMembership() {
    return dateOfMembership;
  }

  public void setDateOfMembership(Date dateOfMembership) {
    this.dateOfMembership = dateOfMembership;
  }

  public Short getTotalBooksCheckedOut() {
    return totalBooksCheckedOut;
  }

  public void setTotalBooksCheckedOut(Short totalBooksCheckedOut) {
    this.totalBooksCheckedOut = totalBooksCheckedOut;
  }

}
