package com.molvenolakeresort.hotel.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime bookedDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn
    private Invoice invoice;

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
}
