package com.molvenolakeresort.models.generic;

import com.molvenolakeresort.models.generic.security.GuestInformation;
import com.molvenolakeresort.models.generic.security.Profile;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class GuestInformationTest {

    private final LocalDate dateOfBirth;

    private final boolean isSubscribedToNewsletter;

    private final Address address;

    private final Profile profile;

    public GuestInformationTest() {
        this.dateOfBirth = LocalDate.of(1990, 01, 01);
        this.isSubscribedToNewsletter = true;
        this.address = new Address();
        this.profile = new Profile();
    }

    @Test
    public void testGetterSetters() {
        GuestInformation guestInformation = new GuestInformation();

        guestInformation.setDateOfBirth(this.dateOfBirth);
        guestInformation.setSubscribedToNewsletter(this.isSubscribedToNewsletter);
        guestInformation.setAddress(this.address);
        guestInformation.setProfile(this.profile);

        assertSame(this.dateOfBirth, guestInformation.getDateOfBirth());
        assertSame(this.isSubscribedToNewsletter, guestInformation.isSubscribedToNewsletter());
        assertNotNull(guestInformation.getAddress());
        assertNotNull(guestInformation.getProfile());

        assertEquals(LocalDate.of(1990, 01, 01), guestInformation.getDateOfBirth());
        assertEquals(true, guestInformation.isSubscribedToNewsletter());
    }
}
