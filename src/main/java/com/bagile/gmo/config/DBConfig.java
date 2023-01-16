package com.bagile.gmo.config;

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


		/*dataSourceBuilder.url("jdbc:postgresql://51.75.250.118:5432/emsdb");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("BAgSin0$2017");*/

	        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/emsdb");
	        dataSourceBuilder.username("postgres");
	        dataSourceBuilder.password("password");



	        return dataSourceBuilder.build();

	}
}
