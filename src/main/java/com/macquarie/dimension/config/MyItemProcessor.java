package com.macquarie.dimension.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by hopeng on 27/4/18.
 */
@Component
class MyItemProcessor implements ItemProcessor<Object, Object> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Object process(Object item) throws Exception {
        System.out.println("out@@@@" + jdbcTemplate.queryForList("select * from test_entity"));
        return item;
    }
}
