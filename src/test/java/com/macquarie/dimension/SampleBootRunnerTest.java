package com.macquarie.dimension;

import org.junit.Test;
import org.springframework.boot.SpringApplication;

public class SampleBootRunnerTest {

    @Test
    public void test() {
        // run job
        SpringApplication.run(DimensionEntry.class);

    }
}
