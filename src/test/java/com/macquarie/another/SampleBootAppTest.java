package com.macquarie.another;

import com.macquarie.dimension.config.BatchConfig;
import com.macquarie.dimension.domain.TestEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@DataJpaTest
//@AutoConfigureDataJpa
//@AutoConfigureTestDatabase
//@Configuration
@EnableAutoConfiguration
@Transactional
@AutoConfigureTestDatabase
@Import({ BatchConfig.class})
public class SampleBootAppTest {

    @Autowired
    private EntityManager entityManager;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public JobLauncherTestUtils jobLauncherTestUtils() {
            return new JobLauncherTestUtils();
        }
    }

    @Autowired
    JobLauncherTestUtils jobLauncherTestUtils;


    @Test
    public void test() throws Exception {
        TestEntity entity = new TestEntity();
        entity.setId("1");
        entity.setAge(11);
        entity.setUpdatedBy(ZonedDateTime.now());
        this.entityManager.persist(entity);
        entityManager.flush();

        System.out.println(entityManager.find(TestEntity.class, "1"));

        List<TestEntity> list = entityManager.createQuery("from TestEntity", TestEntity.class).getResultList();
        System.out.println(list);
        assertEquals(1, list.size());

        jobLauncherTestUtils.launchJob();

    }

}
