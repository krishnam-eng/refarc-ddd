package com.clap.lms.business.repository;

import com.clap.lms.domain.model.account.MemberAccount;

import java.util.List;

public interface MemberRepo {
    void createMembership(MemberAccount member);
    MemberAccount deactivateMember(Integer memberId);
    List<MemberAccount> getAllMembers();
    MemberAccount getMember(Integer membershipId);
}
