package com.macquarie.another.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by hopeng on 8/4/18.
 */
public class DataConfig {

    @Bean
    @ConfigurationProperties(prefix = "another.datasource")
    public DataSource anotherDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean anotherEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(anotherDataSource())
//                .packages(Order.class)
                .persistenceUnit("another")
                .build();
    }
}
