package com.molvenolakeresort.restaurant.restaurant;

import com.molvenolakeresort.restaurant.enums.TableShape;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Table {

    @Id
    private int id;
    private TableShape shape;
    private int maxSeats;
}
