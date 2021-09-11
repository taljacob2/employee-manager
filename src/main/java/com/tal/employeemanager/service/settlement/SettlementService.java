package com.tal.employeemanager.service.settlement;

import com.tal.employeemanager.entity.settlement.Record;
import com.tal.employeemanager.entity.settlement.SettlementEntity;

import java.util.List;

public interface SettlementService {
    List<SettlementEntity> findAll();

    List<SettlementEntity> findByOrderByNameAsc();

    void insertSettlementEntities(List<Record> records);
}
