package com.clap.lms.application.ports;

import com.clap.lms.domain.entities.MemberAccount;

import java.util.List;

public interface MemberRepo {
    void createMembership(MemberAccount member);
    MemberAccount deactivateMember(Integer memberId);
    List<MemberAccount> getAllMembers();
    MemberAccount getMember(Integer membershipId);
}
