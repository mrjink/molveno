package com.molvenolakeresort.repositories.generic;

import com.molvenolakeresort.models.generic.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);

    Country findByCode(String code);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Country c WHERE c.name = ?1 OR c.code = ?2")
    boolean exists(String name, String code);
}
