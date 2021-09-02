package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumerations.AccountStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public class LibrarianAccount extends Account {

  void closeAccount(MemberAccount memberAccount) {
    memberAccount.setAccountStatus(AccountStatus.CLOSED);
  }

  void openAccount(MemberAccount memberAccount) {
    memberAccount.setAccountStatus(AccountStatus.ACTIVE);
  }

  void blockAccount(MemberAccount memberAccount) {
    memberAccount.setAccountStatus(AccountStatus.BLOCKED);
  }

  void unblockAccount(MemberAccount memberAccount) {
    memberAccount.setAccountStatus(AccountStatus.ACTIVE);
  }

  void markAccountDormant(MemberAccount memberAccount) {
    memberAccount.setAccountStatus(AccountStatus.DORMANT);
  }

  // librarian use-cases:
  //  manage book: add book, book items,
  //
}
