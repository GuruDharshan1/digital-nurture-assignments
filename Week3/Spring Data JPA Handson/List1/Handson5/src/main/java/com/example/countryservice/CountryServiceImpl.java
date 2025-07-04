package com.example.countryservice.service;

import com.example.countryservice.entity.Country;
import com.example.countryservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repository;

    @Override
    public Country findCountryByCode(String code) {
        return repository.findById(code).orElse(null);
    }

    @Override
    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    @Override
    public Country addCountry(Country country) {
        return repository.save(country);
    }

    @Override
    public Country updateCountry(String code, Country updatedCountry) {
        Optional<Country> existing = repository.findById(code);
        if (existing.isPresent()) {
            Country country = existing.get();
            country.setName(updatedCountry.getName());
            return repository.save(country);
        }
        return null;
    }

    @Override
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

    @Override
    public List<Country> findByNameContaining(String keyword) {
        return repository.findByNameContaining(keyword);
    }
}
