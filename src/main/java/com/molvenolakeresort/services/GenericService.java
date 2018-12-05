package com.molvenolakeresort.services;

import com.molvenolakeresort.models.generic.Country;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface GenericService {
    Optional<Country> findCountry(long id);
    Country createCountry(Country country);
    Iterable<Country> findAll();
    Iterable<Country> createCountries(Country[] countries);
}

