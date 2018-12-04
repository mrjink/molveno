package com.molvenolakeresort.models.generic;


import com.molvenolakeresort.models.generic.security.Profile;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "Address")
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

    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn
    private Collection<Profile> guests;

    public Address() {}

    public Address(String streetName, String buildingName, String homeNumber, String city, String postalCode) {
        this.streetName = streetName;
        this.buildingName = buildingName;
        this.homeNumber = homeNumber;
        this.city = city;
        this.postalCode = postalCode;
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

    public Collection<Profile> getGuests() {
        return guests;
    }

    public void setGuests(Collection<Profile> guests) {
        this.guests = guests;
    }

}