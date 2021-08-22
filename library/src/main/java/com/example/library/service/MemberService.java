package com.example.library.service;

import com.example.library.model.entity.account.MemberAccount;

import java.util.List;

public interface MemberService {
    public void createMembership(MemberAccount member);
    public MemberAccount deactivateMember(Integer memberId);
    public List<MemberAccount> getAllMembers();
    public MemberAccount getMember(Integer membershipId);
}
