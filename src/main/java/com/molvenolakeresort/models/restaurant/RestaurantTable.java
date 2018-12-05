package com.molvenolakeresort.models.restaurant;

import com.molvenolakeresort.models.restaurant.enums.TableShape;

import javax.persistence.*;

@Entity(name = "RestaurantTable")
public class RestaurantTable {

    private @Id @GeneratedValue
    Long idRestaurantTable;

    private TableShape shape;
    private int maxSeats;

    public RestaurantTable() {

    }

    public TableShape getShape() {
        return shape;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public Long getId() {
        return idRestaurantTable;
    }
}
