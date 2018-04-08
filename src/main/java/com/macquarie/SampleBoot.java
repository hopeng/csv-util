package com.macquarie;

import com.macquarie.dimension.DimensionEntry;
import org.springframework.boot.SpringApplication;

/**
 * Created by hopeng on 7/4/18.
 */
public class SampleBoot {

//    todo try PropertiesLauncher
    public static void main(String[] args) {
        SpringApplication.run(DimensionEntry.class, args);
    }

//    @Autowired
//    private JobLauncherCommandLineRunner jobRunner;

//    @Bean
//    public JobLauncherCommandLineRunner jobRunner(JobLauncher jobLauncher, JobExplorer jobExplorer) {
//        return new JobLauncherCommandLineRunner(jobLauncher, jobExplorer);
//    }
}
