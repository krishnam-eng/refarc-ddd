package com.clap.lms.domain.entities;

import lombok.ToString;

import java.util.Date;

@ToString(callSuper = true)
public class MemberAccount extends Account {
  private Date dateOfMembership;

  private Short totalBooksCheckedOut;

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
// member usecases:
  //  reserve book item
  //  checkout book item
  //  return book item
  //  renew book item
  //  check Fine
  //  settle Fine

}
