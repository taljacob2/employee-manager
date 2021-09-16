package com.tal.employeemanager.service.employee;

import com.tal.employeemanager.entity.employee.EmployeeEntity;
import com.tal.employeemanager.entity.settlement.SettlementEntity;
import com.tal.employeemanager.repository.employee.EmployeeRepository;
import com.tal.employeemanager.repository.settlement.SettlementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j @Service public class EmployeeServiceImpl implements EmployeeService {

    @Autowired EmployeeRepository employeeRepository;

    @Autowired SettlementRepository settlementRepository;

    private String entityNotFoundExceptionMessage(String entity, String name) {
        return entity + " name `" + name + "` was not found.";
    }

    private String entityNotFoundExceptionMessage(String entity, Long id) {
        return entity + " id `" + id + "` was not found.";
    }

    @Override public EmployeeEntity insert(EmployeeEntity employeeEntity) {
        employeeEntity.setCode(UUID.randomUUID().toString());

        Optional<SettlementEntity> settlementEntityOptional =
                validateSettlementExists(employeeEntity);

        return insertEmployee(employeeEntity, settlementEntityOptional.get());
    }

    private EmployeeEntity insertEmployee(EmployeeEntity employeeEntity,
                                          SettlementEntity settlementEntity) {

        // Update employee to have the parent settlement id
        employeeEntity.getSettlementEntity().setId(settlementEntity.getId());

        // Add this employee to the parent settlement
        settlementEntity.getEmployeeEntities().add(employeeEntity);

        /*
         * Save the parent settlement.
         * Also, automatically saves the child employee thanks to cascade.
         */
        settlementRepository.save(settlementEntity);

        return employeeEntity;
    }

    private Optional<SettlementEntity> validateSettlementExists(
            EmployeeEntity employeeEntity) {
        String settlementName = employeeEntity.getSettlementEntity().getName();
        Optional<SettlementEntity> settlementEntityOptional =
                settlementRepository.findByName(settlementName);
        if (!settlementEntityOptional.isPresent()) {
            throw new EntityNotFoundException(
                    entityNotFoundExceptionMessage("SettlementEntity",
                            settlementName));
        }

        return settlementEntityOptional;
    }

    @Override public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override public EmployeeEntity find(Long id) {
        return validateIdExists(id);
    }

    private EmployeeEntity validateIdExists(Long id) {
        Optional<EmployeeEntity> optionalEmployeeEntity =
                employeeRepository.findById(id);
        if (!optionalEmployeeEntity.isPresent()) {
            throw new EntityNotFoundException(
                    entityNotFoundExceptionMessage("EmployeeEntity", id));
        }
        return optionalEmployeeEntity.get();
    }

    @Override public EmployeeEntity update(EmployeeEntity employeeEntity) {
        Long id = employeeEntity.getId();
        validateIdExists(id); // May throw an exception when not found
        return employeeRepository.save(employeeEntity);
    }

    @Override public void delete(Long id) {
        validateIdExists(id); // May throw an exception when not found
        employeeRepository.deleteById(id);
    }
}
