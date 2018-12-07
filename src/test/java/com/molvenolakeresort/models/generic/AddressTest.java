package com.molvenolakeresort.models.generic;

import com.molvenolakeresort.models.generic.Address;
import com.molvenolakeresort.models.generic.Country;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressTest {

    private final String city;
    private final String homenumber;
    private final String streetname;
    private final String postalcode;
    private final String buildingname;
    private final Country country;

    public AddressTest()
    {
        this.city = "Utrecht";
        this.homenumber = "1";
        this.streetname = "Reykjavikplein";
        this.buildingname = "Capgemini Academy";
        this.postalcode = "3543 KA";
        this.country = new Country();
        this.country.setCode("NL");
        this.country.setName("The Netherlands");
    }

    @Test
    public void testGetterSetters() {
        Address address = new Address();
        address.setCountry(this.country);
        address.setPostalCode(this.postalcode);
        address.setHomeNumber(this.homenumber);
        address.setStreetName(this.streetname);
        address.setCity(this.city);
        address.setBuildingName(this.buildingname);

        assertNotNull("Country was not set (this only gets checked if it's set or not)",address.getCountry());
        assertSame(this.postalcode, address.getPostalCode());
        assertSame(this.homenumber, address.getHomeNumber());
        assertSame(this.city, address.getCity());
        assertSame(this.buildingname, address.getBuildingName());

        assertEquals("3543 KA", address.getPostalCode());
        assertEquals("1", address.getHomeNumber());
        assertEquals("Utrecht", address.getCity());
        assertEquals("Capgemini Academy", address.getBuildingName());
    }

}
