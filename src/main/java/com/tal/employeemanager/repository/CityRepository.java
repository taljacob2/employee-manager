package com.tal.employeemanager.repository;

import com.tal.employeemanager.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {}
