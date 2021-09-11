package com.tal.employeemanager.config.record;

import com.tal.employeemanager.entity.settlement.Record;
import com.tal.employeemanager.entity.settlement.Root;
import com.tal.employeemanager.repository.record.RecordRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * The <i>IsraelCityEntity</i> is the {@link Record} class.
 */
@Slf4j @Data @Configuration public class RecordApiConfiguration
        implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${record.api.link}") String recordApiLink;
    @Autowired RecordRepository repository;
    private List<Record> records = null;

    @Override public void run(String... args) throws Exception {
        extractApiAndInsertToDB();
    }

    private void extractApiAndInsertToDB() {
        extractApi();
        insertRecordsToDB();
    }

    private void insertRecordsToDB() {
        for (Record record : records) {
            repository.save(record);
        }
    }

    private void extractApi() {
        try {
            Root root = restTemplate.getForObject(recordApiLink, Root.class);
            records = root.getResult().getRecords();
        } catch (HttpClientErrorException e) {
            log.error(e.getResponseBodyAsString());
        }
    }
}
