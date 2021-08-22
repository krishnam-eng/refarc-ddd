package com.example.library.infra.dataprovider;

import com.example.library.domain.constant.AccountStatus;
import com.example.library.business.repository.MemberRepo;

import com.example.library.domain.model.account.MemberAccount;
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
