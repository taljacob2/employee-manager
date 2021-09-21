package com.tal.employeemanager.service.settlement;

import com.tal.employeemanager.entity.settlement.Record;
import com.tal.employeemanager.entity.settlement.SettlementEntity;

import java.util.List;
import java.util.Optional;

public interface SettlementService {
    List<SettlementEntity> findAll();

    List<SettlementEntity> findByOrderByNameAsc();

    void insertSettlementEntities(List<Record> records);

    Optional<SettlementEntity> findById(int id);
}
