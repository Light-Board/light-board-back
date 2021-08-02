package com.lb.lightboard.bo;

import com.lb.lightboard.model.User;
import com.lb.lightboard.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class UserBOTest extends BaseBOTest{
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserBO sut;
	
	@DisplayName("사용자 > 중복 ID 확인")
	@Test
	public void isDuplicatedUserId() {
		String userId = "12345";
		List<User> users = Collections.emptyList();
		
		when(userRepository.findByUserId(anyString())).thenReturn(users);
		
		boolean result = sut.isDuplicateUserId(userId);
		
		Assertions.assertFalse(result);
		verify(userRepository, times(1)).findByUserId(anyString());
	}
}
