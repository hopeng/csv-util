package com.jsample;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private String Abc;
    private String fewfw;
    private String wefwefwe;
    private String Wef;
    private String Wv;
    private String We;

    public static void main(String [] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CSVJob.class);

        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
        jobLauncher.run(applicationContext.getBean("jobBean", Job.class), null);

    }
}