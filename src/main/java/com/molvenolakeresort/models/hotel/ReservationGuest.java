package com.molvenolakeresort.models.hotel;

import javax.persistence.*;

@Entity
public class ReservationGuest {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private Reservation reservation;

    @ManyToOne
    @JoinColumn
    private Guest guest;

    private boolean isMainBooker;

    public ReservationGuest () {}

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public boolean isMainBooker() {
        return isMainBooker;
    }

    public void setMainBooker(boolean mainBooker) {
        isMainBooker = mainBooker;
    }

    public int getId() {
        return id;
    }
}
