package com.lb.lightboard.servlet;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.lb.lightboard.config.*;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebApplication implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		FilterRegistration securityFilter = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
		securityFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, "/*");

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(EnvironmentConfig.class);
		context.register(WebConfig.class);
		context.register(DBConfig.class);
		context.register(JacksonSnakeCaseConfig.class);
		context.register(SwaggerConfig.class);
		context.register(SwaggerConfigurer.class);
		context.register(SecurityConfig.class);
		servletContext.addListener(new ContextLoaderListener(context));

		// Servlet 설정
		setServletDispatcherContext(context, servletContext);

		// Filter 설정
		setCharacterEncodingFilter(servletContext);
	}

	// Servlet 설정
	private void setServletDispatcherContext(AnnotationConfigWebApplicationContext context,
		ServletContext servletContext) {
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
			new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

	// Filter 설정 > encoding UTF-8
	private void setCharacterEncodingFilter(ServletContext servletContext) {
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter",
			new CharacterEncodingFilter());
		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		characterEncodingFilter.setInitParameter("forceEncoding", "true");
	}
}
