/*
 * UseRepository.java version 2021. 06. 23
 *
 * Copyright 2021 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lb.lightboard.repository;

import com.lb.lightboard.model.type.UserStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.lightboard.model.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUserId(String userId);
	List<User> findByUserStatusType(UserStatusType userStatusType);
}
