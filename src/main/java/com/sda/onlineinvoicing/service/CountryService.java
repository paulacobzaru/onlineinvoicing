package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();

    void saveCountry(Country country);

    void deleteCountry(int countryId);

    Country getCountryById(int countryId);
}
