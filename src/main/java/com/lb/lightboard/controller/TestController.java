/*
 *  TestController.java version 2021. 05. 25
 *
 *  Copyright 2021 NAVER Corp. All rights Reserved.
 *  NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lb.lightboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	@RequestMapping(value = "/")
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value = "/test")
	public String test2() {
		return "seyoung";
	}
}
