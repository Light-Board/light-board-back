package com.lb.lightboard.controller.user;

import com.lb.lightboard.bo.UserBO;
import com.lb.lightboard.controller.CrudController;
import com.lb.lightboard.model.entity.User;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.request.UserApiRequest;
import com.lb.lightboard.model.network.response.UserApiResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends CrudController<UserApiRequest, UserApiResponse, User> {

	@GetMapping(params = "userId")
	public Header<Boolean> isDuplicateUserId(@RequestParam(value = "userId") String userId) {
		return ((UserBO)baseBO).isExistUserId(userId);
	}

	@GetMapping(value = "/admin/check")
	public Header<Boolean> isExistAdminUser() {
		return ((UserBO)baseBO).isExistAdminUser();
	}
}
