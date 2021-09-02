package com.clap.lms.application.usecases;

import com.clap.lms.domain.entities.MemberAccount;

import java.util.List;

public interface MembershipUseCase {
    void createMembership(MemberAccount member);

    MemberAccount blockMember(String memberId);

    MemberAccount unblockMemberAccount(String memberId);

    List<MemberAccount> getAllMemberDetails();

    MemberAccount fetchMemberDetails(String membershipId);

}
