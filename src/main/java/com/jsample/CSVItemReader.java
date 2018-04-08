package com.jsample;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.batch.item.file.transform.DelimitedLineTokenizer.DELIMITER_COMMA;


public class CSVItemReader extends FlatFileItemReader<Map<String, String>> {

    private String headers[];

    @Override
    public void afterPropertiesSet() throws Exception {
        DelimitedLineTokenizer csvTokenizer = new DelimitedLineTokenizer(DELIMITER_COMMA);

        setLinesToSkip(1);
        setSkippedLinesCallback(line -> headers = csvTokenizer.tokenize(line).getValues());

        setLineMapper((line, lineNumber) -> {
            String[] tokens = csvTokenizer.tokenize(line).getValues();
            Map<String, String> result = new LinkedHashMap<>();
            for (int i=0; i<headers.length; i++) {
                result.put(headers[i], tokens.length > i ? tokens[i] : null);
            }
            return result;
        });

        super.afterPropertiesSet();
    }
}
