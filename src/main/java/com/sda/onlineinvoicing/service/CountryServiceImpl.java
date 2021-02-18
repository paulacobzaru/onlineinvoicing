package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Country;
import com.sda.onlineinvoicing.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void deleteCountry(int countryId) {
        countryRepository.deleteById(countryId);
    }

    @Override
    public Country getCountryById(int countryId) {
        return countryRepository.findById(countryId).orElse(new Country());
    }
}
