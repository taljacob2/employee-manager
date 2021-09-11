package com.tal.employeemanager.service.record;

import com.tal.employeemanager.entity.record.Record;
import com.tal.employeemanager.repository.record.RecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j @Service public class RecordServiceImpl implements RecordService {

    @Autowired RecordRepository recordRepository;

    @Override public List<Record> findAll() {
        return recordRepository.findAll();
    }

}
