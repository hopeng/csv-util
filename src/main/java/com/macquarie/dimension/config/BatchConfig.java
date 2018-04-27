package com.macquarie.dimension.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by hopeng on 7/4/18.
 */
@EnableBatchProcessing
@Configuration
public class BatchConfig extends DefaultBatchConfigurer {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EntityManagerFactory dimensionEntityManagerFactory;

    @Autowired
    MyItemProcessor myItemProcessor;

    @Override
    public void setDataSource(DataSource dataSource) {
        // override to do not set datasource even if a datasource exist.
        // initialize() will use a Map based JobRepository (instead of database)
    }

    @Bean
    public Step step1() {
        JpaPagingItemReader reader = new JpaPagingItemReader();
        reader.setEntityManagerFactory(dimensionEntityManagerFactory);
        reader.setQueryString("from TestEntity");

        FlatFileItemWriter<Object> writer = new FlatFileItemWriter<>();
        writer.setResource(new PathResource("batch-out.txt"));
        writer.setLineAggregator(new PassThroughLineAggregator<>());

        return stepBuilderFactory.get("step1")
                .chunk(100)
                .reader(reader)
                .processor(myItemProcessor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job job(Step step1) throws Exception {
        return jobBuilderFactory.get("job1")
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }

}