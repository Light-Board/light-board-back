package com.lb.lightboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
	
//	@RequestMapping(value = "/test")
	@GetMapping(value = "/test")
	public String test2() {
		return "seyoung";
	}
}
