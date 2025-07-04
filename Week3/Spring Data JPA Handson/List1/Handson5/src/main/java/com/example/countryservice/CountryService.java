package com.example.countryservice.service;

import com.example.countryservice.entity.Country;
import java.util.List;

public interface CountryService {
    Country findCountryByCode(String code);
    List<Country> getAllCountries();
    Country addCountry(Country country);
    Country updateCountry(String code, Country updatedCountry);
    void deleteCountry(String code);
    List<Country> findByNameContaining(String keyword);
}
