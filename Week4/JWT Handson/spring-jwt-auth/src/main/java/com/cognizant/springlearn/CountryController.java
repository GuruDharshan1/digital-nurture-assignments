package com.cognizant.springlearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return List.of(
                new Country("IN", "India"),
                new Country("US", "United States"),
                new Country("FR", "France")
        );
    }
}

class Country {
    private String code;
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
