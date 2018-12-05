package com.molvenolakeresort.models.restaurant;

import com.molvenolakeresort.models.restaurant.enums.TableShape;

import javax.persistence.*;

@Entity
public class Table {

    private @Id @GeneratedValue
    Long id;

    private TableShape shape;
    private int maxSeats;

    public Table() {

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
