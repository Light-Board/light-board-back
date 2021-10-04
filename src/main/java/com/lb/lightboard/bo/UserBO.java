package com.lb.lightboard.bo;

import com.lb.lightboard.model.entity.User;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.status.ApiResponseStatus;
import com.lb.lightboard.model.type.UserStatusType;
import com.lb.lightboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserBO {
	@Autowired
	UserRepository userRepository;
	
	public Header<Boolean> isExistUserId(String userId) {
		List<User> users = userRepository.findByUserId(userId);
		boolean result = users.size() > 0;
		
		log.info("[Check Duplicate UserId] Is Duplicate User : {}", result);
		
		return new Header<>(result, ApiResponseStatus.READ_DATA, "Exist Duplicate User");
	}
	
	public Header<Boolean> isExistAdminUser() {
		List<User> adminUsers = ((UserRepository)baseRepository).findByUserAuthorityType(UserAuthorityType.ADMIN);
		boolean result = !adminUsers.isEmpty();
		
		log.debug("[Check Exist Admin User] Is Exist Admin User : {}", result);
		
		return new Header<>(result, ApiResponseStatus.READ_DATA, "Exist Admin User");
	}
}