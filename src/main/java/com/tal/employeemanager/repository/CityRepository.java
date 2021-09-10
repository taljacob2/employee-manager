package com.tal.employeemanager.repository;

import com.tal.employeemanager.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    Optional<CityEntity> findByName(String name);
}
