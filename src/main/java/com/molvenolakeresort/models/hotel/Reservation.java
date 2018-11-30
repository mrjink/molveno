package com.molvenolakeresort.models.hotel;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime bookedDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

    @OneToOne
    @JoinColumn
    private Invoice invoice;

    @OneToMany(mappedBy = "reservation")
    private Set<ReservationGuest> reservationGuests = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "reservations")
    private Set<Room> rooms = new HashSet<>();

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(LocalDateTime bookedDate) {
        this.bookedDate = bookedDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<ReservationGuest> getReservationGuests() {
        return reservationGuests;
    }

    public void setReservationGuests(Set<ReservationGuest> reservationGuests) {
        this.reservationGuests = reservationGuests;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
