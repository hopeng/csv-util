package com.macquarie.dimension.config;

import com.macquarie.dimension.DimensionEntry;
import com.macquarie.hibernate.SpringPhysicalNamingStrategy;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Collections;

import static org.hibernate.cfg.AvailableSettings.PHYSICAL_NAMING_STRATEGY;

/**
 * Created by hopeng on 8/4/18.
 */
@Configuration
public class DimensionDataConfig {

    @Bean
    @ConfigurationProperties(prefix = "dimension.datasource")
    public DataSource dimensionDataSource() {
        return new HikariDataSource();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean dimensionEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return buildEMF(builder, dimensionDataSource(), DimensionEntry.class);
    }

    public static LocalContainerEntityManagerFactoryBean buildEMF(EntityManagerFactoryBuilder builder, DataSource ds,
                                                            Class entryClass) {
        return builder
                .dataSource(ds)
                .properties(Collections.singletonMap(PHYSICAL_NAMING_STRATEGY, SpringPhysicalNamingStrategy.class.getName()))
                .packages(entryClass.getPackage().getName())
                .persistenceUnit(entryClass.getSimpleName())
                .build();
    }
}
