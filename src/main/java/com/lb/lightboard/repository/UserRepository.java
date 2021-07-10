/*
 * UseRepository.java version 2021. 06. 23
 *
 * Copyright 2021 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lb.lightboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.lightboard.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public boolean findByUserId(String userId);
}
