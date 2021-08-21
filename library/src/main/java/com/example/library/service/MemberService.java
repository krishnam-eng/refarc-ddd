package com.example.library.service;

import com.example.library.domain.Member;

import java.util.List;

public interface MemberService {
    public void createMembership(Member member);
    public Member deactivateMember(Integer memberId);
    public List<Member> getAllMembers();
    public Member getMember(Integer membershipId);
}
