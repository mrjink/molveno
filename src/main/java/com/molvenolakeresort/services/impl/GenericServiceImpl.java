package com.molvenolakeresort.services.impl;


import com.molvenolakeresort.models.generic.Country;
import com.molvenolakeresort.repositories.generic.CountryRepository;
import com.molvenolakeresort.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Optional<Country> findCountry(long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country createCountry(Country country) {
        Country countryResult = countryRepository.save(country);
        if(countryResult != null)
        {
            System.out.println(String.format("New country (id): %s", countryResult.getId()));
        }
        return countryRepository.save(country);
    }

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Iterable<Country> createCountries(Country[] countries)
    {
        Iterable<Country> countryIterable = new ArrayList<Country>();
        if(countries != null) {
            for (int i = 0; i < countries.length; i++)
            {
                ((ArrayList<Country>) countryIterable).add(countries[i]);
            }
        }

        countryIterable = countryRepository.saveAll(countryIterable);
        System.out.println(String.format("Mutated %s records.", ((List<Country>) countryIterable).size()));
        return countryIterable;
    }
}