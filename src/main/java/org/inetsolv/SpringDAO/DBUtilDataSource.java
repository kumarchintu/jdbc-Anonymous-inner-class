package org.inetsolv.SpringDAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:org/inetsolv/SpringDAO/config/db.properties")
public class DBUtilDataSource {
	@Autowired
	Environment environment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getProperty("db.driverClass"));
		driverManagerDataSource.setUrl(environment.getProperty("db.url"));
		driverManagerDataSource.setUsername(environment.getProperty("db.userName"));
		driverManagerDataSource.setPassword(environment.getProperty("db.password"));
		return driverManagerDataSource;
	}
}
