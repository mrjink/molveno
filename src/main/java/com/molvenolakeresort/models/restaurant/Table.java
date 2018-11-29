package com.molvenolakeresort.models.restaurant;

import com.molvenolakeresort.models.kitchen.enums.TableShape;
import com.molvenolakeresort.models.kitchen.restaurant.Reservation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Table {

    @Id
    private int id;
    private TableShape shape;
    private int maxSeats;

    @ManyToOne
//    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    public Table(int id, TableShape shape, int maxSeats) {
        this.id = id;
        this.shape = shape;
        this.maxSeats = maxSeats;
    }
}
