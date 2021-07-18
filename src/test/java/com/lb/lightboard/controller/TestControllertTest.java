/*
 * TestControllertTest.java version 2021. 06. 21
 *
 * Copyright 2021 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lb.lightboard.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestControllertTest {
	@Test
	public void testAdd() {
		Assertions.assertEquals(42, Integer.sum(19, 23));
	}
}
