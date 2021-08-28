package com.lb.lightboard.model.network.request;

import com.lb.lightboard.model.type.UserAuthorityType;
import com.lb.lightboard.model.type.UserStatusType;
import lombok.Getter;

@Getter
public class UserApiRequest {
	String userId;
	String password;
	String passwordSort;
	String email;
	UserAuthorityType userAuthorityType;
	UserStatusType userStatusType;
	int reportedCnt;
	long profileUserNo;
}
