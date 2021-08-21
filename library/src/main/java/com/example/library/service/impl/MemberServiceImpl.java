package com.example.library.service.impl;

import com.example.library.constant.AccountStatus;
import com.example.library.service.MemberService;

import com.example.library.domain.Member;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberServiceImpl implements MemberService {
    List<Member> members = new ArrayList<>();
    Map<Integer, Member> memberMap = new HashMap<>();

    @Override
    public void createMembership(Member member) {
        if (memberMap.get(member.getId()) == null) {
            memberMap.put(member.getId(), member);
            member.setCreatedOn(new Date());
            members.add(member);
        } else {
            throw new IllegalStateException("Please try new id. Member already exist for " + member.getId() + " id");
        }
    }

    @Override
    public Member deactivateMember(Integer memberId) {
        Member member1 = memberMap.get(memberId);
        member1.setAccountStatus(AccountStatus.BLOCKED);
        return member1;
    }

    @Override
    public List<Member> getAllMembers() {
        return members;
    }

    @Override
    public Member getMember(Integer membershipId) {
        return memberMap.get(membershipId);
    }
}
