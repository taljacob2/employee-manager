package com.tal.employeemanager.service.city;

import com.tal.employeemanager.entity.CityEntity;
import com.tal.employeemanager.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.util.List;

@Slf4j @Service public class CityServiceImpl implements CityService {

    @Autowired CityRepository cityRepository;

    @Override public CityEntity insert(CityEntity cityEntity) {
        CityEntity returnValue = null;
        try {
            returnValue = cityRepository.save(cityEntity);
        } catch (RuntimeException e) {
            throw new NonUniqueResultException(
                    "the name: `" + cityEntity.getName() +
                            "` is unique, and had already been placed.");
        }
        return returnValue;
    }

    @Override public List<CityEntity> findAll() {
        return cityRepository.findAll();
    }

}
