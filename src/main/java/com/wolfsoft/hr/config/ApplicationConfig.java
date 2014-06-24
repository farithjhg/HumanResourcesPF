package com.wolfsoft.hr.config; 

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* <p>Title: Clase ApplicationConfig Generada por Masterclass Ver 2.0 </p>
*
* <p>Description: Annotation based repository configuration 
* </p>
*
* <p>Copyright: Copyright (c) 2014</p>
*
* <p>Company: Wolfsoft Co.</p>
*
* @author Farith José Heras García
* @version 1.0
*/
@Configuration
@EnableJpaRepositories(basePackages = { "com.wolfsoft.hr.repository" }, repositoryImplementationPostfix = "CustomImpl")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.wolfsoft.hr"}) 
public class ApplicationConfig{
     @Bean
     public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/hr");
//		dataSource.setUsername("root");
//		dataSource.setPassword("Master");

		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:file:~/hrdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
     }

     @Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
 		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.wolfsoft.hr.entity");
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

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
    }

}
