package com.example.library.domain;

import com.example.library.constant.AccountStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString(callSuper = true)
@Getter
@Setter
public class Member extends Account {
    private Date createdOn;
    private Short holdingBooksCount;

}
