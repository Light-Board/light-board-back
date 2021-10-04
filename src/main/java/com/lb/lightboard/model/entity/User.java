package com.lb.lightboard.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.network.request.UserApiRequest;
import com.lb.lightboard.model.type.UserAuthorityType;
import com.lb.lightboard.model.type.UserQuestionType;
import com.lb.lightboard.model.type.UserStatusType;
import com.lb.lightboard.model.type.converter.UserAuthorityTypeConverter;
import com.lb.lightboard.model.type.converter.UserQuestionTypeConverter;
import com.lb.lightboard.model.type.converter.UserStatusTypeConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_no")
	Long userNo;
	@Column(name = "user_id")
	String userId;
	@Column(name = "password")
	String password;
	@Column(name = "password_sort")
	String passwordSort;
	@Column(name = "email")
	String email;
	@Convert(converter = UserAuthorityTypeConverter.class)
	@Column(name = "authority")
	UserAuthorityType userAuthorityType;
	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime createAt;
	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime updateAt;
	@Column(name = "updated_user_no")
	Long updatedUserNo;
	@Column(name = "updated_detail")
	String updatedDetail;
	@Convert(converter = UserStatusTypeConverter.class)
	@Column(name = "status")
	UserStatusType userStatusType;
	@Column(name = "reported_cnt")
	int reportedCnt;
	@Column(name = "user_name")
	String userName;
	@Column(name = "image_url")
	String imageUrl;
	@Column(name = "user_interest")
	String userInterest;
	@Column(name = "question_answer")
	String questionAnswer;
	@Convert(converter = UserQuestionTypeConverter.class)
	@Column(name = "question_type")
	UserQuestionType userQuestionType;

	public User(UserApiRequest userApiRequest) {
		this.userNo = userApiRequest.getUserNo();
		this.userId = userApiRequest.getUserId();
		this.password = userApiRequest.getPassword();
		this.passwordSort = userApiRequest.getPasswordSort();
		this.email = userApiRequest.getEmail();
		this.userAuthorityType = userApiRequest.getUserAuthorityType();
		this.createAt = userApiRequest.getCreateAt();
		this.updateAt = userApiRequest.getUpdateAt();
		this.updatedUserNo = userApiRequest.getUpdatedUserNo();
		this.updatedDetail = userApiRequest.getUpdatedDetail();
		this.userStatusType = userApiRequest.getUserStatusType();
		this.reportedCnt = userApiRequest.getReportedCnt();
		this.userName = userApiRequest.getUserName();
		this.imageUrl = userApiRequest.getImageUrl();
		this.userInterest = userApiRequest.getUserInterest();
		this.questionAnswer = userApiRequest.getQuestionAnswer();
		this.userQuestionType = userApiRequest.getUserQuestionType();
	}
}
