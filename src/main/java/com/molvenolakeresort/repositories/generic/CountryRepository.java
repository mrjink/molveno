package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(@Param("name") String name);
    Country findByCode(@Param("code") String code);
    boolean exists(@Param("name") String name, @Param("code") String code);
}
