package com.macquarie.dimension.config;

import com.macquarie.dimension.DimensionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
public class DimensionJpaConfig {

    @Autowired
    DataSource dimensionDataSource;

//    @Bean
//    public LocalContainerEntityManagerFactoryBean dimensionEntityManagerFactory(
//            EntityManagerFactoryBuilder builder) {
////        LocalContainerEntityManagerFactoryBean
//
//        return builder
//                .dataSource(dimensionDataSource)
//                .packages(DimensionEntry.class.getPackage().getName())
//                .persistenceUnit(DimensionEntry.class.getSimpleName())
//                .build();
//    }
}
