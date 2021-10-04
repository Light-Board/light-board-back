package com.lb.lightboard.repository;

import com.lb.lightboard.model.type.UserStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lb.lightboard.model.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByUserId(String userId);
	List<User> findByUserId(String userId);
	List<User> findByUserStatusType(UserStatusType userStatusType);
}
