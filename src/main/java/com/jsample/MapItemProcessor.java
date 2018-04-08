package com.jsample;

import org.springframework.batch.item.ItemProcessor;

import java.util.Map;

/**
 * Created by hopeng on 17/3/18.
 */
public class MapItemProcessor implements ItemProcessor<Map<String, String>, Map<String, String>> {
    @Override
    public Map<String, String> process(Map<String, String> item) throws Exception {
        return item;
    }
}
