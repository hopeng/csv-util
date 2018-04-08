package com.macquarie.twods;

import com.macquarie.dimension.DimensionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by hopeng on 7/4/18.
 */
@SpringBootApplication
public class DsBoot implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DsBoot.class, args);
    }

    @Autowired
    DataSource dimensionDataSource;

    @Override
    public void run(String... args) throws Exception {
        List<Map<String, Object>> out = new JdbcTemplate(dimensionDataSource).queryForList("select * from test_entity");
        System.out.println(out);
    }
}
