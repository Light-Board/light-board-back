package com.lb.lightboard.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerTest extends BaseControllerTest {
	@Autowired
	public UserController userController;
	
	@Test
	public void isDuplicatedUserId() {
		boolean result = userController.isDuplicateUserId("12345");
		
		Assertions.assertFalse(result);
	}
}
