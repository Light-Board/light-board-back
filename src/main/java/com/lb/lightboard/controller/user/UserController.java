package com.lb.lightboard.controller.user;

import com.lb.lightboard.bo.UserBO;
import com.lb.lightboard.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/admin/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	@Autowired
	UserBO userBO;
	
	@GetMapping(params = "userId")
	public Header<Boolean> isDuplicateUserId(@RequestParam(value = "userId") String userId) {
		return userBO.isExistUserId(userId);
	}
	
	@GetMapping(value = "/admin/check")
	public Header<Boolean> isExistAdminUser() {
		return userBO.isExistAdminUser();
	}
}
