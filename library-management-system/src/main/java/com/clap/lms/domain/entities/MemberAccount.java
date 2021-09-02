package com.clap.lms.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import java.util.Date;

@ToString(callSuper = true)
@Getter
@Setter
public class MemberAccount extends Account {
  private Date dateOfMembership;

  private Short totalBooksCheckedOut;

  // member usecases:
  //  reserve book item
  //  checkout book item
  //  return book item
  //  renew book item
  //  check Fine
  //  settle Fine

}
