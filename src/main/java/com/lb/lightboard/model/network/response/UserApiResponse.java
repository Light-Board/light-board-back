package com.lb.lightboard.model.network.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.entity.User;
import com.lb.lightboard.model.type.UserAuthorityType;
import com.lb.lightboard.model.type.UserQuestionType;
import com.lb.lightboard.model.type.UserStatusType;

import java.time.LocalDateTime;

public class UserApiResponse {
	Long userNo;
	String userId;
	String email;
	UserAuthorityType userAuthorityType;
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime createAt;
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime updateAt;
	Long updatedUserNo;
	String updateDetail;
	UserStatusType userStatusType;
	int reportedCnt;
	String userName;
	String imageUrl;
	String userInterest;
	String questionAnswer;
	UserQuestionType userQuestionType;

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
		this.userName = user.getUserName();
		this.imageUrl = user.getImageUrl();
		this.userInterest = user.getImageUrl();
		this.questionAnswer = user.getQuestionAnswer();
		this.userQuestionType = user.getUserQuestionType();
	}
}
