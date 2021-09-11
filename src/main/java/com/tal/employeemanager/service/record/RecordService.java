package com.tal.employeemanager.service.record;

import com.tal.employeemanager.entity.settlement.Record;

import java.util.List;

public interface RecordService {
    List<Record> findAll();
}
