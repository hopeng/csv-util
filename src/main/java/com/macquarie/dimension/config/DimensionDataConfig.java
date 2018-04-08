package com.macquarie.dimension.config;

import com.macquarie.dimension.DimensionEntry;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by hopeng on 8/4/18.
 */
@Configuration
public class DimensionDataConfig {

    @Primary // todo required for EntityManagerFactoryBuilder?
    @Bean
    @ConfigurationProperties(prefix = "dimension.datasource")
    public DataSource dimensionDataSource() {
        return new HikariDataSource();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean dimensionEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dimensionDataSource())
                .packages(DimensionEntry.class.getPackage().getName())
                .persistenceUnit("dimension")
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "another.datasource")
    public DataSource anotherDataSource() {
        return new HikariDataSource();
    }
}
