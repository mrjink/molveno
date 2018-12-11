package com.molvenolakeresort.models.generic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CountryTest {

    private final String name;
    private final String code;

    public CountryTest() {
        this.code = "NL";
        this.name = "The Netherlands";
    }

    @Test
    public void testGetterSetters() {
        Country country = new Country();
        country.setName(this.name);
        country.setCode(this.code);

        assertSame(this.code, country.getCode());
        assertSame(this.name, country.getName());

        assertEquals("NL", country.getCode());
        assertEquals("The Netherlands", country.getName());
    }

}
