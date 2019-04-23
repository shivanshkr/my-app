package com.my_app.utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.my_app.config.SpringConfig;

public class ContextFactory {
	private static final ApplicationContext CONTEXT =  new AnnotationConfigApplicationContext(SpringConfig.class);
	
	public static ApplicationContext getContext() {
		return CONTEXT;
	}
}
