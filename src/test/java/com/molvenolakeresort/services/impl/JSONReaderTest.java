package com.molvenolakeresort.services.impl;

import com.molvenolakeresort.models.generic.Country;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class JSONReaderTest {

    JSONReader jsonReader;

    @Test
    public void happyFlow() {
        try {
            Country[] countries = new JSONReader<Country>().initObject(Country.class, "json/country.json");
            assertNotNull(countries);
            assertTrue(countries.length > 0);
            Stream.of(countries).forEach(country -> System.out.println(country.toString()));

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
