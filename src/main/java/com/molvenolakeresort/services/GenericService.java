package com.molvenolakeresort.services;

import com.molvenolakeresort.models.generic.Country;

import java.util.Optional;

public interface GenericService {
    Optional<Country> findCountry(long id);

    Country findCountryByName(String name);

    Country findCountryByCode(String code);

    Country createCountry(Country country);

    Iterable<Country> findAll();

    Iterable<Country> createCountries(Country[] countries);
}

