package com.my_app.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@ComponentScan(basePackages = "com.my_app")
public class SpringConfig{
	
	@Bean
	public DataSource dataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("T561311");
	    dataSource.setPassword("T561311");
	    return dataSource;
	}
	
	@Bean("sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
	        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	        sessionFactoryBean.setDataSource(dataSource());
	        sessionFactoryBean.setPackagesToScan("com.my_app.entity");
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
	        hibernateProperties.setProperty("hibernate.show_sql", "true");
	        hibernateProperties.setProperty("hibernate.format_sql", "false");
	        sessionFactoryBean.setHibernateProperties(hibernateProperties);
	        return sessionFactoryBean;
	    }
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory, DataSource dataSource) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory);
	    transactionManager.setDataSource(dataSource);
	    return transactionManager;
	}




}
