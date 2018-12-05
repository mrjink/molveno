package com.molvenolakeresort.models.generic.security;

import com.molvenolakeresort.models.generic.Address;
import com.molvenolakeresort.models.generic.LanguageCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Guestinformation")
@Table(name = "guestinformation")
public class GuestInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat
    private LocalDate dateOfBirth;

    private boolean isSubscribedToNewsletter;

    //TODO: force address integration
    @ManyToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "guestInformation", optional = false)
    private Profile profile;

    public GuestInformation() {}

    public GuestInformation(LocalDate dateOfBirth, Address address) {
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean isSubscribedToNewsletter() {
        return isSubscribedToNewsletter;
    }

    public void setSubscribedToNewsletter(boolean subscribedToNewsletter) {
        isSubscribedToNewsletter = subscribedToNewsletter;
    }
}
