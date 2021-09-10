package com.tal.employeemanager.config;

import com.tal.employeemanager.entity.israelcityapi.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j @Controller("/") public class IsraelCityAPIConfiguration {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${israel.city.api.link}") String israelCityAPILink;

    @GetMapping @ResponseBody Root getAPI() {
        Root root = null;
        try {
            root = restTemplate.getForObject(israelCityAPILink, Root.class);
        } catch (HttpClientErrorException e) {
            log.error(e.getResponseBodyAsString());
        }
        return root;
    }
}
