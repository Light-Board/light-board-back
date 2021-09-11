package com.lb.lightboard.controller.common;

import com.lb.lightboard.controller.CrudController;
import com.lb.lightboard.model.entity.Configuration;
import com.lb.lightboard.model.network.request.ConfigurationApiRequest;
import com.lb.lightboard.model.network.response.ConfigurationApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/configuration", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConfigurationController extends CrudController<ConfigurationApiRequest, ConfigurationApiResponse, Configuration> {
}
