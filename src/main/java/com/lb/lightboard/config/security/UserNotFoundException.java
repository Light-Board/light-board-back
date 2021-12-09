package com.lb.lightboard.config.security;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String userId) {
		super(userId + "NotFoundException");
	}
}
