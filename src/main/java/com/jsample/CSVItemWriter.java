package com.jsample;

import com.jsample.Column;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hopeng on 17/3/18.
 */
public class CSVItemWriter extends FlatFileItemWriter {

    private Column headers[];

    public CSVItemWriter(Column... headers) {
        this.headers = headers;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setLineAggregator(new DelimitedLineAggregator());

        super.afterPropertiesSet();
        setHeaderCallback(writer -> {
            writer.append(Arrays.stream(headers).map(Object::toString).collect(Collectors.joining(",")));
        });
    }
}
