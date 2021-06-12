/*
 *  DBConfig.java version 2021. 05. 29
 *
 *  Copyright 2021 NAVER Corp. All rights Reserved.
 *  NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lb.lightboard.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableTransactionManagement
@Slf4j
public class DBConfig implements TransactionManagementConfigurer{

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(ConfigConstants.DATASOURCE_DRIVER_CLASS_NAME);
		dataSource.setUrl(ConfigConstants.DATASOURCE_URL);
		dataSource.setUsername(ConfigConstants.DATASOURCE_USER_NAME);
		dataSource.setPassword(ConfigConstants.DATASOURCE_PASSWORD);
		return dataSource;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManger();
	}

	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(dataSource());
	}
}
