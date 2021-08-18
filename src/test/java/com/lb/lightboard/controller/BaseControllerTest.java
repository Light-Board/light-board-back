package com.lb.lightboard.controller;

import com.lb.lightboard.config.DBConfig;
import com.lb.lightboard.config.EnvironmentConfig;
import com.lb.lightboard.config.WebConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, DBConfig.class, EnvironmentConfig.class})
public class BaseControllerTest {
	//
}
