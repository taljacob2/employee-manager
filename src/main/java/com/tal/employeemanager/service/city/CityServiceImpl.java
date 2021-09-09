package com.tal.employeemanager.service.city;

import com.tal.employeemanager.entity.CityEntity;
import com.tal.employeemanager.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service public class CityServiceImpl implements CityService {

    @Autowired CityRepository cityRepository;

    @Override public CityEntity insert(CityEntity cityEntity) {
        return cityRepository.save(cityEntity);
    }

}
