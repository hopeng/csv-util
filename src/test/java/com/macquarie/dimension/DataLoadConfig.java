package com.macquarie.dimension;

import com.macquarie.dimension.domain.Currency;
import com.macquarie.dimension.domain.TestEntity;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created by hopeng on 9/4/18.
 */
@TestConfiguration
public class DataLoadConfig {
    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }

    @Autowired
    DataSource dimensionDataSource;

    @Autowired
    EntityManagerFactory dimensionEntityManagerFactory;

    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {
        System.out.println("a context refreshed event happened");
        loadData();
    }

    private void loadData() {
        EntityManager entityManager = dimensionEntityManagerFactory.createEntityManager();

        TestEntity entity = new TestEntity();
        entity.setId("1");
        entity.setAge(11);
        entity.setUpdatedBy(ZonedDateTime.now());
        entity.setCurrency(Currency.AUD);

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private void loadDataJdbc() {
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
