package com.krishna.MultiDB.StudentDB;

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
public class StudentDBConfig {

    @Autowired
    Environment env;

    @Bean("studentDBDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("student.datasource.driver-class-name"));
        dataSource.setUsername(env.getProperty("student.datasource.username"));
        dataSource.setPassword(env.getProperty("student.datasource.password"));
        dataSource.setUrl(env.getProperty("student.datasource.url"));

        return dataSource;
    }


    @Bean("stundetDBEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean stundetDBEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.krishna.MultiDB.StudentDB.Entitys");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(StundetDBAdditionalProperties());

        return em;
    }

    public Properties StundetDBAdditionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("student.jpa.hibernate.ddl-auto"));
        properties.setProperty("hibernate.dialect", env.getProperty("student.jpa.hibernate.dialect"));
        return properties;
    }

}
