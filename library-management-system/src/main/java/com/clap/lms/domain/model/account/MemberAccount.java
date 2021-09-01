package com.clap.lms.domain.model.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import java.util.Date;

@ToString(callSuper = true)
@Getter
@Setter
public class MemberAccount extends Account {
    private Date createdOn;

    @Max(5)
    private Short holdingBooksCount;

}
