/*
 * UserBO.java version 2021. 06. 23
 *
 * Copyright 2021 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lb.lightboard.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.lightboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserBO {
	@Autowired
	UserRepository userRepository;

	public boolean isDuplicateUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
}
