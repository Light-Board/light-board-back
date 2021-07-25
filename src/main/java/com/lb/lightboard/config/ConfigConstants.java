/*
 * ConfigConstants.java version 2021. 06. 07
 *
 * Copyright 2021 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lb.lightboard.config;

public class ConfigConstants {
	public static final String DATASOURCE_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String DATASOURCE_URL = "jdbc:mysql://104.249.128.241:3306/light_board?serverTimezone=UTC";
	public static final String DATASOURCE_USER_NAME = "light_board";
	public static final String DATASOURCE_PASSWORD = "lightboard123!#";

	public static final int CONNECTION_POOL_INITIAL_POOL_SIZE = 5;
	public static final int CONNECTION_POOL_MIN_POOL_SIZE = 5;
	public static final int CONNECTION_POOL_MAX_POOL_SIZE = 20;
	public static final int CONNECTION_POOL_MAX_IDLE_TIME = 3000;

	public static final boolean HIBERNATE_SHOW_SQL = true;
	public static final String HIBERNATE_PACKAGES_TO_SCAN = "com.lb.lightboard.repository";
	public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLDialect";

	public static final String JPA_DATABASE_PLATFORM  = "org.hibernate.dialect.MySQL5InnoDBDialect";
	public static final boolean JPA_OPEN_IN_VIEW = false;
	public static final boolean JPA_SHOW_SQL = true;
	public static final boolean JPA_HIBERNATE_FORMAT_SQL = true;
	public static final String JPA_HIBERNATE_DDL_AUTO = "create";
}
