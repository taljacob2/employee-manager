package com.tal.employeemanager.service.city;

import com.tal.employeemanager.entity.CityEntity;

import java.util.List;

public interface CityService {

    CityEntity insert(CityEntity cityEntity);

    List<CityEntity> findAll();
}
