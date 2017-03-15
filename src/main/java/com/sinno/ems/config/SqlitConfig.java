/**
 * 
 */
package com.sinno.ems.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Sinno
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.sinno.ems.sqlite.repositories"})
@EnableTransactionManagement
@Import({SecurityConfig.class})
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan({"com.sinno.*"})
public class SqlitConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySqlite() {
    	    	
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(sqliteDataSource());
        em.setPackagesToScan("com.sinno.ems.sqlite.entities");
 
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.FALSE);
        vendorAdapter.setShowSql(Boolean.TRUE);
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<String, Object>();
        //properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("sqlite.hibernate.dialect"));
        em.setJpaPropertyMap(properties);
 
        return em;
    }

    @Bean
    public DataSource sqliteDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("sqlite.driver"));
        dataSource.setUrl(env.getProperty("sqlite.datasource.url"));
        dataSource.setUsername(env.getProperty("sqlite.datasource.username"));
        dataSource.setPassword(env.getProperty("sqlite.datasource.password"));
 
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager sqlitTransactionManager() {
        EntityManagerFactory factory = entityManagerFactorySqlite().getObject();
        return new JpaTransactionManager(factory);
    }
}
