package com.lb.lightboard.controller.admin;

import com.lb.lightboard.controller.CrudController;
import com.lb.lightboard.model.entity.User;
import com.lb.lightboard.model.network.request.UserApiRequest;
import com.lb.lightboard.model.network.response.UserApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/admin/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminUserController extends CrudController<UserApiRequest, UserApiResponse, User> {
}
