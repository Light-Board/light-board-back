package com.lb.lightboard.model.network.response;

import com.lb.lightboard.model.entity.User;
import com.lb.lightboard.model.type.UserAuthorityType;
import com.lb.lightboard.model.type.UserStatusType;

public class UserApiResponse {
	long userNo;
	String userId;
	String email;
	UserAuthorityType userAuthorityType;
	long createAt;
	long updateAt;
	long updatedUserNo;
	String updateDetail;
	UserStatusType userStatusType;
	int reportedCnt;
	long profileUserNo;

	public UserApiResponse(User user) {
		this.userNo = user.getUserNo();
		this.userId = user.getUserId();
		this.email = user.getEmail();
		this.userAuthorityType = user.getUserAuthorityType();
		this.createAt = user.getCreateAt();
		this.updateAt = user.getUpdateAt();
		this.updatedUserNo = user.getUpdatedUserNo();
		this.updateDetail = user.getUpdatedDetail();
		this.userStatusType = user.getUserStatusType();
		this.reportedCnt = user.getReportedCnt();
		this.profileUserNo = user.getProfileUserNo();
	}
}
