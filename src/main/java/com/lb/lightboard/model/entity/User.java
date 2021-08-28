package com.lb.lightboard.model.entity;

import javax.persistence.*;

import com.lb.lightboard.model.type.UserAuthorityType;
import com.lb.lightboard.model.type.UserStatusType;
import com.lb.lightboard.model.type.converter.UserStatusTypeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_no")
	long userNo;
	@Column(name = "user_id")
	String userId;
	@Column(name = "password")
	String password;
	@Column(name = "password_sort")
	String passwordSort;
	@Column(name = "email")
	String email;
	@Column(name = "authority")
	UserAuthorityType userAuthorityType;
	@Column(name = "created_at")
	long createAt;
	@Column(name = "updated_at")
	long updateAt;
	@Column(name = "updated_user_no")
	long updatedUserNo;
	@Column(name = "updated_detail")
	String updatedDetail;
	@Convert(converter = UserStatusTypeConverter.class)
	@Column(name = "status")
	UserStatusType userStatusType;
	@Column(name = "reported_cnt")
	int reportedCnt;
	@Column(name = "profile_user_no")
	long profileUserNo;
}
