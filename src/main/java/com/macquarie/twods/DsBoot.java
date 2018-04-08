package com.macquarie.twods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by hopeng on 7/4/18.
 */
@SpringBootApplication(exclude = JpaRepositoriesAutoConfiguration.class)
//@EnableConfigurationProperties(PropsTest.class)
public class DsBoot implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DsBoot.class, args);
    }

    @Autowired
    DataSource dimensionDataSource;

    @Autowired
    PropsTest propsTest;

    @Override
    public void run(String... args) throws Exception {
        List<Map<String, Object>> out = new JdbcTemplate(dimensionDataSource).queryForList("select * from test_entity");
        System.out.println("result=" + out);
        System.out.println(propsTest);
    }
}
