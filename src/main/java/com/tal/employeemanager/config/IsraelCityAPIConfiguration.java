package com.tal.employeemanager.config;

import com.tal.employeemanager.entity.israelcityapi.Record;
import com.tal.employeemanager.entity.israelcityapi.Root;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j @Data @Configuration public class IsraelCityAPIConfiguration
        implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${israel.city.api.link}") String israelCityAPILink;
    private List<Record> records = null;

    @Override public void run(String... args) throws Exception {
        extractAPI();
    }

    private void extractAPI() {
        try {
            Root root =
                    restTemplate.getForObject(israelCityAPILink, Root.class);
            records = root.getResult().getRecords();
        } catch (HttpClientErrorException e) {
            log.error(e.getResponseBodyAsString());
        }
    }

}
