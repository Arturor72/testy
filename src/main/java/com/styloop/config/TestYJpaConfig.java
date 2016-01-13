package com.styloop.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.styloop.common.TestYConstants;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.styloop.persistence" })
@PropertySource({ "classpath:datasource.properties" })
public class TestYJpaConfig {
	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean ent = new LocalContainerEntityManagerFactoryBean();
		ent.setDataSource(getDatasource());
		ent.setPackagesToScan(new String[] { "com.styloop.model" });
		JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		ent.setJpaVendorAdapter(vendor);
		ent.setJpaProperties(additionalProperties());
		return ent;
	}

	@Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	      return transactionManager;
	   }
	
	@Bean
	public DataSource getDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(TestYConstants.DATABASE_DRIVER_PROPERTIE));
		dataSource.setUrl(env.getProperty(TestYConstants.DATABASE_URL_PROPERTIE));
		dataSource.setUsername(env.getProperty(TestYConstants.DATABASE_USER_PROPERTIE));
		dataSource.setPassword(env.getProperty(TestYConstants.DATABASE_PASSWORD_PROPERTIE));
		return dataSource;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty(TestYConstants.HIBERNATE_AUTO_PROPERTIE,
				env.getProperty(TestYConstants.HIBERNATE_AUTO_PROPERTIE));
		properties.setProperty(TestYConstants.HIBERNATE_DIALECT_PROPERTIE,
				env.getProperty(TestYConstants.HIBERNATE_DIALECT_PROPERTIE));
		properties.setProperty(TestYConstants.HIBERNATE_SHOW_SQL_PROPERTIE,
				env.getProperty(TestYConstants.HIBERNATE_SHOW_SQL_PROPERTIE));
		return properties;
	}
}
