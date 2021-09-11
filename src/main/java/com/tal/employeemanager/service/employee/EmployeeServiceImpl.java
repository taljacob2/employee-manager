package com.tal.employeemanager.service.employee;

import com.tal.employeemanager.entity.employee.EmployeeEntity;
import com.tal.employeemanager.repository.employee.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j @Service public class EmployeeServiceImpl implements EmployeeService {

    @Autowired EmployeeRepository employeeRepository;

    private String entityNotFoundExceptionMessage(Long id) {
        return "EmployeeEntity id `" + id + "` was not found.";
    }

    @Override public EmployeeEntity insert(EmployeeEntity employeeEntity) {
        employeeEntity.setCode(UUID.randomUUID().toString());
        return employeeRepository.save(employeeEntity);
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
                    entityNotFoundExceptionMessage(id));
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
