package com.example.library.business.repository;

import com.example.library.domain.model.account.MemberAccount;

import java.util.List;

public interface MemberRepo {
    void createMembership(MemberAccount member);
    MemberAccount deactivateMember(Integer memberId);
    List<MemberAccount> getAllMembers();
    MemberAccount getMember(Integer membershipId);
}
