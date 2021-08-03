package com.lb.lightboard.bo;

import com.lb.lightboard.model.entity.User;
import com.lb.lightboard.model.User;
import com.lb.lightboard.model.type.UserStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lb.lightboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class UserBO {
	@Autowired
	UserRepository userRepository;

	public boolean isDuplicateUserId(String userId) {
		List<User> users = userRepository.findByUserId(userId);
		log.debug("users : {}", users);
		return users.size() > 0;
	}
	
	public boolean isExistAdminUser() {
		List<User> adminUsers = userRepository.findByUserStatusType(UserStatusType.ADMIN);
		log.debug("admin users : {}", adminUsers);
		return !adminUsers.isEmpty();
	}
}