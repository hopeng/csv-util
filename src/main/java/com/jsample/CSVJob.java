package com.jsample;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.ResourceLoader;

import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by hopeng on 17/3/18.
 */
@Configuration
@EnableBatchProcessing
public class CSVJob {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public CSVItemReader csvReader() {
        CSVItemReader result = new CSVItemReader();
        result.setResource(resourceLoader.getResource("classpath:input.csv"));
        return result;
    }

    @Bean
    public ItemProcessor processor() {
        return new MapItemProcessor();
    }

    @Bean
    public ItemWriter csvWriter() {
        CSVItemWriter result = new CSVItemWriter();
        result.setResource(new PathResource(Paths.get("build/out.csv")));
        result.setLineAggregator(new PassThroughLineAggregator());
        return result;
    }

    @Bean
    public Step step1() {
        return steps.get("step1")
                .<Map, Map> chunk(10)
                .reader(csvReader())
                .processor(processor())
                .writer(csvWriter())
                .build();

    }

    @Bean
    public Job jobBean() throws Exception {
        return jobs.get("myJob").start(step1()).build();
    }
}
