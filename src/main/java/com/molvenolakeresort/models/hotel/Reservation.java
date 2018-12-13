package com.molvenolakeresort.models.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.molvenolakeresort.models.hotel.enums.Pet;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime bookedDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private String bookedBy;
    private Pet pet;
    private int nrAdults;
    private int nrChildren;
    private String remarks;
    private boolean approved;

    @OneToMany(mappedBy = "reservation")
    private Set<Invoice> invoices = new HashSet<>();
    @OneToMany(mappedBy = "reservation")
    @JsonIgnore
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

    public boolean isCheckedIn() {
        return checkInDate != null && checkOutDate == null;
    }

    public boolean isReservationValid() {
        LocalDate today = LocalDate.now();
        return ((today.compareTo(startDate.toLocalDate()) >= 0 &&
                 today.compareTo(endDate.toLocalDate()) <= 0) || isCheckedIn());
    }

    public long getId() {
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

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getNrAdults() {
        return nrAdults;
    }

    public void setNrAdults(int nrAdults) {
        this.nrAdults = nrAdults;
    }

    public int getNrChildren() {
        return nrChildren;
    }

    public void setNrChildren(int nrChildren) {
        this.nrChildren = nrChildren;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
