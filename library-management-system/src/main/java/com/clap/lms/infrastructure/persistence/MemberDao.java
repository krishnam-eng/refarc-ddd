package com.clap.lms.infrastructure.persistence;

import com.clap.lms.application.ports.MemberRepo;
import com.clap.lms.domain.entities.MemberAccount;
import com.clap.lms.domain.enumerations.AccountStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberDao implements MemberRepo {
  List<MemberAccount> members = new ArrayList<>();
  Map<Integer, MemberAccount> memberMap = new HashMap<>();

  @Override
  public void createMembership(MemberAccount member) {
    if (memberMap.get(member.getAccountId()) == null) {
      memberMap.put(member.getAccountId(), member);
      member.setCreatedOn(new Date());
      members.add(member);
    } else {
      throw new IllegalStateException(
          "Please try new id. Member already exist for " + member.getAccountId() + " id");
    }
  }

  @Override
  public MemberAccount deactivateMember(Integer memberId) {
    MemberAccount member1 = memberMap.get(memberId);
    member1.setAccountStatus(AccountStatus.BLOCKED);
    return member1;
  }

  @Override
  public List<MemberAccount> getAllMembers() {
    return members;
  }

  @Override
  public MemberAccount getMember(Integer membershipId) {
    return memberMap.get(membershipId);
  }
}
