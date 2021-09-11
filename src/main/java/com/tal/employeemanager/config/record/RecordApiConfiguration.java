package com.tal.employeemanager.config.record;

import com.tal.employeemanager.entity.settlement.Record;
import com.tal.employeemanager.entity.settlement.Root;
import com.tal.employeemanager.service.settlement.SettlementService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * The <i>IsraelCityEntity</i> is the {@link Record} class.
 */
@Slf4j @ConditionalOnProperty(name = "record.api.fetch.enabled")
@EnableScheduling @Data @Configuration public class RecordApiConfiguration {

    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired SettlementService settlementService;
    @Value("${record.api.link}") private String recordApiLink;

    /**
     * Initial {@code @Bean} GET API.
     * <blockquote>Note: Depends on {@code record.api.fetch.enabled} in
     * <tt>application.properties</tt> file.
     * </blockquote>
     *
     * @return Records extracted from API.
     */
    @Bean public List<Record> insertSettlementEntities() {
        List<Record> records = extractRecordsFromApi();
        settlementService.insertSettlementEntities(records);
        return records;
    }

    /**
     * {@code @Scheduled} GET API.
     * <blockquote> Note: The host <tt>data.gov.il</tt> is updating once per
     * 15 minutes.</blockquote>
     * <blockquote>Note: Depends on {@code record.api.fetch.enabled} in
     * <tt>application.properties</tt> file.
     * </blockquote>
     */
    @Scheduled(fixedRateString = "${record.api.fetch.delay}",
            initialDelayString = "${record.api.fetch.delay}")
    private void insertSettlementEntitiesScheduled() {
        insertSettlementEntities();
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

}
