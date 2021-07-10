/*
 *  DBConfig.java version 2021. 05. 29
 *
 *  Copyright 2021 NAVER Corp. All rights Reserved.
 *  NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lb.lightboard.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
@EnableJpaRepositories("com.lb.lightboard.repository")
@EnableTransactionManagement
public class DBConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(ConfigConstants.DATASOURCE_DRIVER_CLASS_NAME);
		dataSource.setUrl(ConfigConstants.DATASOURCE_URL);
		dataSource.setUsername(ConfigConstants.DATASOURCE_USER_NAME);
		dataSource.setPassword(ConfigConstants.DATASOURCE_PASSWORD);
		dataSource.setInitialSize(100);
		dataSource.setMaxIdle(30);
		dataSource.setMinIdle(20);
		dataSource.setMaxWaitMillis(10000);

		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		factory.setJpaProperties(properties());
		factory.setPackagesToScan("com.lb.lightboard.model");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	private Properties properties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "none");
		return  properties;
	}
}
