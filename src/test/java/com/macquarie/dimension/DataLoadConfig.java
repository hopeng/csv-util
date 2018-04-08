package com.macquarie.dimension;

import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by hopeng on 9/4/18.
 */
@Configuration
public class DataLoadConfig {
    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }

    @Autowired
    DataSource dimensionDataSource;

    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {
        System.out.println("a context refreshed event happened");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dimensionDataSource);
        jdbcTemplate.update("insert into test_entity(id, age) VALUES ('1', 11)");
        List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from test_entity");
        System.out.println("result: "+ result);
    }

//    @Bean
//    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder factory) {
//        return new JpaTransactionManager(dimensionDataConfig.dimensionEntityManagerFactory(factory).getObject());
//    }
}
