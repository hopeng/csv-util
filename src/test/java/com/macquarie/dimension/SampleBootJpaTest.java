package com.macquarie.dimension;

import com.macquarie.dimension.domain.TestEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SampleBootJpaTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void test() {
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
    }

}
