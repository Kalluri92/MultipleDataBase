package com.krishna.MultiDB.EmployeeDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class EmployeeDBConfig {

    @Autowired
    Environment env;

    @Bean("employeeDBDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("employee.datasource.driver-class-name"));
        dataSource.setUsername(env.getProperty("employee.datasource.username"));
        dataSource.setPassword(env.getProperty("employee.datasource.password"));
        dataSource.setUrl(env.getProperty("employee.datasource.url"));

        return dataSource;
    }


    @Bean("employeeDBEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean employeeDBEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.krishna.MultiDB.EmployeeDB.Entitys");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(employeeDBAdditionalProperties());

        return em;
    }

    public Properties employeeDBAdditionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("employee.jpa.hibernate.ddl-auto"));
        properties.setProperty("hibernate.dialect", env.getProperty("employee.jpa.hibernate.dialect"));
        return properties;
    }
}
