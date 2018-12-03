package com.molvenolakeresort.models.restaurant;

import com.molvenolakeresort.models.restaurant.enums.TableShape;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Table {

    private @Id
    @GeneratedValue
    Long id;
    private TableShape shape;
    private int maxSeats;
/*
    @ManyToOne
//    @JoinColumn(name="reservation_id")
    private Reservation reservation;
*/
    public Table() {

    }

    public Table(Long id, TableShape shape, int maxSeats) {
        this.id = id;
        this.shape = shape;
        this.maxSeats = maxSeats;
    }

    public TableShape getShape() {
        return shape;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public Long getId() {
        return id;
    }
}
