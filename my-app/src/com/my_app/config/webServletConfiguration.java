package com.my_app.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class webServletConfiguration implements WebApplicationInitializer{
	
	public AnnotationConfigWebApplicationContext webContext = null;
	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		// TODO Auto-generated method stub
		webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(DispatcherConfig.class);
		webContext.setServletContext(ctx);
		ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webContext));
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}

}
