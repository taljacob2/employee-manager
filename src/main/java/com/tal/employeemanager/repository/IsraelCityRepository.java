package com.tal.employeemanager.repository;

import com.tal.employeemanager.entity.israelcityapi.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsraelCityRepository
        extends JpaRepository<Record, Long> {}
