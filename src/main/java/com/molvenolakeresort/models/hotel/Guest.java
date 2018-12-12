package com.molvenolakeresort.models.hotel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Guest {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn
    private Address address;
    private String phoneNumber;
    private String email;
    private boolean newsletterSubscribed;


    @OneToMany(mappedBy = "guest")
    private Set<ReservationGuest> reservationGuests = new HashSet<>();

    public Guest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    public void setNewsletterSubscribed(boolean newsletterSubscribed) {
        this.newsletterSubscribed = newsletterSubscribed;
    }

    public Set<ReservationGuest> getReservationGuests() {
        return reservationGuests;
    }

    public void setReservationGuests(Set<ReservationGuest> reservationGuests) {
        this.reservationGuests = reservationGuests;
    }
}
