package com.tal.employeemanager.service;

import com.tal.employeemanager.entity.EmployeeEntity;
import com.tal.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service public class EmployeeServiceImpl implements EmployeeService {

    @Autowired EmployeeRepository employeeRepository;

    public EmployeeEntity insert(EmployeeEntity employeeEntity) {
        employeeEntity.setCode(UUID.randomUUID().toString());
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity find(Long id) {
        Optional<EmployeeEntity> optionalEmployeeEntity =
                employeeRepository.findById(id);
        if (!optionalEmployeeEntity.isPresent()) {
            throw new EntityNotFoundException(
                    "EmployeeEntity id: " + id + "was not found.");
        }
        return optionalEmployeeEntity.get();
    }

    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
