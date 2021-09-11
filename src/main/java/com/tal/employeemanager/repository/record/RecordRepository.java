package com.tal.employeemanager.repository.record;

import com.tal.employeemanager.entity.settlement.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository
        extends JpaRepository<Record, Long> {}
