package com.tal.employeemanager.service.employee;

import com.tal.employeemanager.entity.CityEntity;
import com.tal.employeemanager.entity.EmployeeEntity;
import com.tal.employeemanager.repository.CityRepository;
import com.tal.employeemanager.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j @Service public class EmployeeServiceImpl implements EmployeeService {

    @Autowired EmployeeRepository employeeRepository;

    @Autowired CityRepository cityRepository;

    private String entityNotFoundExceptionMessage(Long id) {
        return "EmployeeEntity id `" + id + "` was not found.";
    }

    @Override public EmployeeEntity insert(EmployeeEntity employeeEntity) {
        employeeEntity.setCode(UUID.randomUUID().toString());
        EmployeeEntity returnValue = null;
        try {
            insertCity(employeeEntity);
            returnValue = insertEmployee(employeeEntity);
        } catch (Exception e) {
            log.error("Exception caught!");
        }

        return returnValue;
    }

    private EmployeeEntity insertEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    /**
     * Checking that {@link EmployeeEntity#getCity()} is being saved too, and is
     * {@code unique}.
     *
     * @param employeeEntity the requested {@link EmployeeEntity} to be saved,
     *                       which includes the {@link CityEntity#getName()}.
     */
    private void insertCity(EmployeeEntity employeeEntity) {
        String cityName = employeeEntity.getCity().getName();
        Optional<CityEntity> cityEntityOptional =
                cityRepository.findByName(cityName);
        if (cityEntityOptional.isPresent()) {

            // City record found:
            employeeEntity.setCity(cityEntityOptional.get());
        } else {

            // City record not found:
            CityEntity cityEntity = new CityEntity();
            cityEntity.setName(cityName);
            cityRepository.save(cityEntity); // Insert CityEntity
            employeeEntity.setCity(cityEntity);
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
