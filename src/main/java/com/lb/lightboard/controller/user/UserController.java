package com.lb.lightboard.controller.user;

import com.lb.lightboard.model.entity.User;
import com.lb.lightboard.model.network.status.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.lb.lightboard.model.network.Header;

import com.lb.lightboard.bo.UserBO;

@RestController
@RequestMapping(value = "/v1/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	@Autowired
	UserBO userBO;

	@GetMapping(params = "userId")
	public Header<Boolean> isDuplicateUserId(@RequestParam(value = "userId") String userId) {
//		return null;
		return new Header<>(ResponseStatus.BOOLEAN_SUCCESS, userBO.isDuplicateUserId(userId));
	}
	
	@GetMapping(value = "/admin/check")
	public Header<Boolean> isExistAdminUser() {
//		return null;
		return new Header<>(ResponseStatus.BOOLEAN_SUCCESS, userBO.isExistAdminUser());
	}
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		userBO.createUser(user);
	}
}
