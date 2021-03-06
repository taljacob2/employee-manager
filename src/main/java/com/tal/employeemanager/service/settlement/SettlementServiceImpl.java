package com.tal.employeemanager.service.settlement;

import com.tal.employeemanager.entity.settlement.Record;
import com.tal.employeemanager.entity.settlement.SettlementEntity;
import com.tal.employeemanager.repository.settlement.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service public class SettlementServiceImpl implements SettlementService {

    @Autowired SettlementRepository settlementRepository;

    @Override public List<SettlementEntity> findAll() {
        return settlementRepository.findAll();
    }

    @Override public List<SettlementEntity> findByOrderByNameAsc() {
        return settlementRepository.findByOrderByNameAsc();
    }

    @Override public void insertSettlementEntities(List<Record> records) {
        for (Record record : records) {
            SettlementEntity settlementEntity = new SettlementEntity();
            settlementEntity.setId(record.get_id());
            settlementEntity.setName(record.getשם_ישוב().trim());
            if (!settlementRepository.findByName(settlementEntity.getName())
                    .isPresent()) {
                settlementRepository.save(settlementEntity);
            }
        }
    }

    @Override public Optional<SettlementEntity> findById(int id) {
        return settlementRepository.findById(id);
    }

}
