package com.clap.lms.application.usecases;

import com.clap.lms.domain.entities.MemberAccount;
import com.clap.lms.domain.enumerations.AccountStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MembershipService implements MembershipUseCase {
  List<MemberAccount> members = new ArrayList<>();
  Map<String, MemberAccount> memberMap = new HashMap<>();

  @Override
  public void createMembership(MemberAccount member) {
    if (memberMap.get(member.getAccountId()) == null) {
      member.setDateOfMembership(new Date());
      members.add(member);
      memberMap.put(member.getAccountId(), member);
    } else {
      throw new IllegalStateException(
          "Please try different user name. Member already exist for " + member.getAccountId() + " user id");
    }
  }

  @Override
  public MemberAccount blockMember(String memberId) {
    MemberAccount member = memberMap.get(memberId);
    member.setAccountStatus(AccountStatus.BLOCKED);
    return member;
  }

  @Override
  public MemberAccount unblockMemberAccount(String memberId) {
    MemberAccount member = memberMap.get(memberId);
    member.setAccountStatus(AccountStatus.ACTIVE);
    return member;
  }

  @Override
  public List<MemberAccount> getAllMemberDetails() {
    return members;
  }

  @Override
  public MemberAccount fetchMemberDetails(String membershipId) {
    return memberMap.get(membershipId);
  }
}
