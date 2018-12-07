package com.molvenolakeresort.models.generic;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.molvenolakeresort.models.generic.security.GuestInformation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String streetName;
    private String buildingName;
    private String homeNumber;
    private String city;
    private String postalCode;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private Collection<GuestInformation> guestInformations = new ArrayList<>();

    public Address() {
    }

    public Address(String streetName, String buildingName, String homeNumber, String city, String postalCode, Country country) {
        this.streetName = streetName;
        this.buildingName = buildingName;
        this.homeNumber = homeNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Collection<GuestInformation> getGuestInformations() {
        return this.guestInformations;
    }

    public void setGuests(Collection<GuestInformation> guestInformations) {
        this.guestInformations = guestInformations;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}