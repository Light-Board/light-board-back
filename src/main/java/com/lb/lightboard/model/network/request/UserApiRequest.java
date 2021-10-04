package com.lb.lightboard.model.network.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.type.UserAuthorityType;
import com.lb.lightboard.model.type.UserQuestionType;
import com.lb.lightboard.model.type.UserStatusType;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserApiRequest {
	Long userNo;
	String userId;
	String password;
	String passwordSort;
	String email;
	UserAuthorityType userAuthorityType;
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime createAt;
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime updateAt;
	Long updatedUserNo;
	String updatedDetail;
	UserStatusType userStatusType;
	int reportedCnt;
	String userName;
	String imageUrl;
	String userInterest;
	String questionAnswer;
	UserQuestionType userQuestionType;
}
