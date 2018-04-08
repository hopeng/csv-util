package com.macquarie.dimension.config;

import com.macquarie.dimension.DimensionEntry;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "dimension.datasource")
    public DataSource dimensionDataSource() {
//        return new HikariDataSource();
        return DataSourceBuilder.create().build();
    }
}
