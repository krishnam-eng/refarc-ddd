package com.clap.lms.infrastructure.persistence;

import com.clap.lms.domain.enumurations.AccountStatus;
import com.clap.lms.application.ports.MemberRepo;

import com.clap.lms.domain.entities.MemberAccount;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberDao implements MemberRepo {
    List<MemberAccount> members = new ArrayList<>();
    Map<Integer, MemberAccount> memberMap = new HashMap<>();

    @Override
    public void createMembership(MemberAccount member) {
        if (memberMap.get(member.getId()) == null) {
            memberMap.put(member.getId(), member);
            member.setCreatedOn(new Date());
            members.add(member);
        } else {
            throw new IllegalStateException("Please try new id. Member already exist for " + member.getId() + " id");
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
