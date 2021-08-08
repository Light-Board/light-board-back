package com.lb.lightboard.controller;

import com.lb.lightboard.model.network.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerTest extends BaseControllerTest {
	@Autowired
	public UserController userController;
	
	@Test
	public void isDuplicatedUserId() {
		Header<Boolean> result = userController.isDuplicateUserId("12345");
		
		Assertions.assertFalse(result.getData());
	}
}
