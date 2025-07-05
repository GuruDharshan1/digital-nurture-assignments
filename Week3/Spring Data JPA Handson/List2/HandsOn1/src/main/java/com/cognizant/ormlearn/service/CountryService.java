package com.cognizant.ormlearn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> searchContaining(String keyword) {
        return countryRepository.findByNameContaining(keyword);
    }

    public List<Country> searchContainingSorted(String keyword) {
        return countryRepository.findByNameContainingOrderByNameAsc(keyword);
    }

    public List<Country> searchStartingWith(String letter) {
        return countryRepository.findByNameStartingWith(letter);
    }
}
