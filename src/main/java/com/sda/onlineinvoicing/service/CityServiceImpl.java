package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.City;
import com.sda.onlineinvoicing.repository.CityRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteCity(int cityId) {
        cityRepository.deleteById(cityId);
    }

    @Override
    public City getCityById(int cityId) {
        return cityRepository.findById(cityId).orElse(new City());
    }
}
