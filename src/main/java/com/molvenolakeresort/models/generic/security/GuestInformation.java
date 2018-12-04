package com.molvenolakeresort.models.generic.security;

import com.molvenolakeresort.models.generic.Address;
import com.molvenolakeresort.models.generic.LanguageCode;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ManyToOne(optional = false)
    private Address address;

    @OneToOne(mappedBy = "guestInformation", cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
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
}
