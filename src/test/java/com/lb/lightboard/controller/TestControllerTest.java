package com.lb.lightboard.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

public class TestControllerTest extends BaseControllerTest {
	@Value("${datasource.driver-class-name}")
	String value;
	
	@Test
	public void testAdd() {
		Assertions.assertEquals(42, Integer.sum(19, 23));
	}
	
	@Test
	public void testFile() {
		System.out.println("Value : " + value);
	}
}
