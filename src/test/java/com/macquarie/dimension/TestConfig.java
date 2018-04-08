package com.macquarie.dimension;

import com.macquarie.dimension.config.DimensionDataConfig;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by hopeng on 9/4/18.
 */
@TestConfiguration
public class TestConfig {
    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }

    @Autowired
    DimensionDataConfig dimensionDataConfig;

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder factory) {
        return new JpaTransactionManager(dimensionDataConfig.dimensionEntityManagerFactory(factory).getObject());
    }
}
