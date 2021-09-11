package com.tal.employeemanager.config.record;

import com.tal.employeemanager.entity.settlement.Record;
import com.tal.employeemanager.entity.settlement.Root;
import com.tal.employeemanager.repository.settlement.RecordRepository;
import com.tal.employeemanager.service.settlement.SettlementService;
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

    @Autowired RecordRepository repository; // FIXME: Unused. Redundant.

    @Autowired SettlementService settlementService;

    @Override public void run(String... args) throws Exception {
        List<Record> records = extractRecordsFromApi();
        settlementService.insertSettlementEntities(records);
        // insertRecords(records);
    }

    private List<Record> extractRecordsFromApi() {
        List<Record> returnValue = null;
        try {
            Root root = restTemplate.getForObject(recordApiLink, Root.class);
            returnValue = root.getResult().getRecords();
        } catch (HttpClientErrorException e) {
            log.error(e.getResponseBodyAsString());
        }
        return returnValue;
    }

    private void insertRecords(List<Record> records) {
        for (Record record : records) {
            repository.save(record);
        }
    }
}
