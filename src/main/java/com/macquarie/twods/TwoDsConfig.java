package com.macquarie.twods;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by hopeng on 8/4/18.
 */
@Configuration
public class TwoDsConfig {

    @Bean
    @ConfigurationProperties(prefix = "dimension.datasource")
    public DataSource dimensionDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties(prefix = "another.datasource")
    public DataSource anotherDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}

