package com.tal.employeemanager.service.employee;

import com.tal.employeemanager.entity.EmployeeEntity;
import com.tal.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service public class EmployeeServiceImpl implements EmployeeService {

    @Autowired EmployeeRepository employeeRepository;

    private String entityNotFoundExceptionMessage(Long id) {
        return "EmployeeEntity id `" + id + "` was not found.";
    }

    @Override public EmployeeEntity insert(EmployeeEntity employeeEntity) {
        employeeEntity.setCode(UUID.randomUUID().toString());
        try {
            return employeeRepository.save(employeeEntity);
        } catch (IllegalArgumentException e) {
            throw new NonUniqueResultException(
                    "the city name: `" + employeeEntity.getCity().getName() +
                            "` is unique, and had already been placed.");
        }
    }

    @Override public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override public EmployeeEntity find(Long id) {
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

        if (id == null) {
            throw new EntityNotFoundException(
                    entityNotFoundExceptionMessage(id));
        }

        if (find(id) == null) {
            throw new EntityNotFoundException(
                    entityNotFoundExceptionMessage(id));
        }

        return employeeRepository.save(employeeEntity);
    }

    @Override public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
