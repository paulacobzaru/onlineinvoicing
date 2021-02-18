package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.City;
import java.util.List;

public interface CityService {
    List<City> getAllCities();

    void saveCity(City city);

    void deleteCity(int city);

    City getCityById(int city);
}

