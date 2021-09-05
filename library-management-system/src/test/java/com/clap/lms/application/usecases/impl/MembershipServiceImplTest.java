package com.clap.lms.application.usecases.impl;

import com.clap.lms.BaseTest;
import com.clap.lms.application.usecases.MembershipService;
import com.clap.lms.domain.entities.MemberAccount;
import com.clap.lms.domain.enumerations.AccountStatus;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class MembershipServiceImplTest extends BaseTest {
  public static final Logger LOG = LoggerFactory.getLogger(MembershipServiceImplTest.class);

  @Mock
  MembershipService membershipService;

  EasyRandom easyRandom = new EasyRandom();

  @Test
  void blockMember() {
    MemberAccount member = easyRandom.nextObject(MemberAccount.class);
    member.setAccountStatus(AccountStatus.ACTIVE);
    LOG.info(member.toString());
    membershipService.createMembership(member);
    member.setAccountStatus(AccountStatus.BLOCKED);
    Mockito.when(membershipService.blockMember("hi")).thenReturn(member);

    MemberAccount memberOut = membershipService.blockMember("hi");

    assertThat(memberOut, notNullValue());
    assertThat(memberOut.getAccountStatus(), equalTo(AccountStatus.BLOCKED));

    LOG.info(member.toString());
  }

  @Test
  void unblockMemberAccount() {}

  @Test
  void fetchMemberDetails() {}
}
