package com.molvenolakeresort.repositories;

import com.molvenolakeresort.models.generic.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
