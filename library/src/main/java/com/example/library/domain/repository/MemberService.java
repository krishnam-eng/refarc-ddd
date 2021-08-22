package com.example.library.domain.repository;

import com.example.library.domain.model.account.MemberAccount;

import java.util.List;

public interface MemberService {
    void createMembership(MemberAccount member);
    MemberAccount deactivateMember(Integer memberId);
    List<MemberAccount> getAllMembers();
    MemberAccount getMember(Integer membershipId);
}
