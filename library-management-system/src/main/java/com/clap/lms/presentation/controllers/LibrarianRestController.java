package com.clap.lms.presentation.controllers;

import com.clap.lms.application.usecases.MembershipUseCase;
import com.clap.lms.domain.entities.MemberAccount;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/librarian")
public class LibrarianRestController {
  public static final Logger log = LoggerFactory.getLogger(LibrarianRestController.class);

  MembershipUseCase membershipService;

  public LibrarianRestController(MembershipUseCase membershipService) {
    this.membershipService = membershipService;
  }

  @PostMapping(path = "/createMemberAccount")
  public void createMemberAccount(@Validated MemberAccount memberAccount) {
    log.debug(memberAccount.toString());
    membershipService.createMembership(memberAccount);
  }

  @GetMapping(path = "/fetchMemberDetail")
  public MemberAccount fetchMemberDetail(String memberId) {
    log.debug(memberId);
    return membershipService.fetchMemberDetails(memberId);
  }

  @GetMapping(path = "/getAllMemberDetails")
  public List<MemberAccount> getAllMemberDetails() {
    return membershipService.getAllMemberDetails();
  }

  @GetMapping("blockMemberAccount")
  public MemberAccount blockMemberAccount(String memberId) {
    log.debug(memberId);
    return membershipService.blockMember(memberId);
  }

  @GetMapping("unblockMemberAccount")
  public MemberAccount unblockMemberAccount(String memberId) {
    log.debug(memberId);
    return membershipService.unblockMemberAccount(memberId);
  }

  @DeleteMapping("deleteMemberAccount")
  public void deleteMemberAccount(MemberAccount memberAccount) {
    log.debug(memberAccount.toString());
    throw new UnsupportedOperationException("FUNCTIONALITY_IS_NOT_IMPLEMENTED");
  }
}
