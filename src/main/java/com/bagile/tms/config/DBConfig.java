package com.bagile.tms.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Bean
	public DataSource dataSource() {
	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("org.postgresql.Driver");
	        dataSourceBuilder.url("jdbc:postgresql://192.168.1.83:5432/emsdb");
	        dataSourceBuilder.username("postgres");
	        dataSourceBuilder.password("postgres");
	        return dataSourceBuilder.build();   
	}
}
