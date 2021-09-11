package com.tal.employeemanager.repository.settlement;

import com.tal.employeemanager.entity.settlement.SettlementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SettlementRepository
        extends JpaRepository<SettlementEntity, Long> {
    Optional<SettlementEntity> findByName(String name);
    List<SettlementEntity> findByOrderByNameAsc();
}
