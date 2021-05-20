package com.migpalser.mylitecrm.MyLiteCrm;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class MyLiteCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLiteCrmApplication.class, args);
	}

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		/*
		 * dataSourceBuilder.driverClassName("org.h2.Driver");
		 * dataSourceBuilder.url("jdbc:h2:mem:test");
		 * dataSourceBuilder.username("testuser"); dataSourceBuilder.password("testpass");
		 */
		dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mariadb://localhost:3306/litecrm");
		dataSourceBuilder.username("testuser");
		dataSourceBuilder.password("testpass");

		return dataSourceBuilder.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setDataSource(getDataSource());
		entityManagerFactoryBean.setPackagesToScan("com.migpalser.mylitecrm.MyLiteCrm");

		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MariaDB103Dialect");
		entityManagerFactoryBean.setJpaProperties(properties);

		return entityManagerFactoryBean;
	}

	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionmanager=new JpaTransactionManager();
		transactionmanager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionmanager;
	}
}
