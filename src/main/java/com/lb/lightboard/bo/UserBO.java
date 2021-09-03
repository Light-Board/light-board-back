package com.lb.lightboard.bo;

import com.lb.lightboard.model.entity.User;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.request.UserApiRequest;
import com.lb.lightboard.model.network.response.UserApiResponse;
import com.lb.lightboard.model.network.status.ApiResponseStatus;
import com.lb.lightboard.model.type.UserStatusType;
import com.lb.lightboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserBO extends BaseBO<UserApiRequest, UserApiResponse, User> {
	
	@Transactional
	@Override
	public Header<UserApiResponse> create(Header<UserApiRequest> request) {
		UserApiRequest userApiRequest = request.getData();
		
		User user = new User(userApiRequest);
		User newUser = baseRepository.save(user);
		
		log.info("[Create User] userInfo : {}", newUser);
		
		return new Header<>(new UserApiResponse(newUser), ApiResponseStatus.CREATE_DATA, "User");
	}

	@Override
	public Header<UserApiResponse> read(long id) {
		User user = baseRepository.findById(id).orElse(null);

		log.info("[Read User] User : {}", user);

		return new Header<>(new UserApiResponse(user), ApiResponseStatus.READ_DATA, "User");
	}

	@Override
	public Header<List<UserApiResponse>> search(Pageable pageable) {
		return null;
	}

	@Override
	public Header<UserApiResponse> update(Header<UserApiRequest> request) {
		UserApiRequest userApiRequest = request.getData();
		
		User user = baseRepository.findById(userApiRequest.getUserNo()).orElse(null);
		if (user == null) {
			return Header.ERROR("There is no any data for id");
		}
		
		baseRepository.save(new User(userApiRequest));
		log.info("[Update User] User : {}", user);
		return new Header<>(new UserApiResponse(user), ApiResponseStatus.UPDATE_DATA, "User");
	}

	@Override
	public Header<UserApiResponse> delete(long id) {
		User user = baseRepository.findById(id).orElse(null);
		
		if (user == null) {
			return Header.ERROR("There is no any data for id");
		}
		log.info("[Delete User] User : {}", user);
		return new Header<>(new UserApiResponse(user), ApiResponseStatus.DELETE_DATA, "User");
	}
	
	public Header<Boolean> isExistUserId(String userId) {
		List<User> users = ((UserRepository) baseRepository).findByUserId(userId);
		boolean result = users.size() > 0;
		
		log.info("[Check Duplicate UserId] Is Duplicate User : {}", result);
		
		return new Header<>(result, ApiResponseStatus.READ_DATA, "Exist Duplicate User");
	}
	
	public Header<Boolean> isExistAdminUser() {
		List<User> adminUsers = ((UserRepository) baseRepository).findByUserStatusType(UserStatusType.ADMIN);
		boolean result = !adminUsers.isEmpty();
		
		log.debug("[Check Exist Admin User] Is Exist Admin User : {}", result);
		
		return new Header<>(result, ApiResponseStatus.READ_DATA, "Exist Admin User");
	}
}