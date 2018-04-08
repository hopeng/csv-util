package com.macquarie.dimension;

import org.junit.Test;
import org.springframework.boot.SpringApplication;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Import(DataLoadConfig.class)
public class SampleBootRunnerTest {

    @Test
    public void test() {
        // run job
        SpringApplication.run(new Class[] {DimensionEntry.class, DataLoadConfig.class}, new String[0]);

    }
}
