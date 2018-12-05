package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier_Ingredient {

    //Double primary key for many to many relation
    @Id
    private Supplier supplier;
    @Id
    private Ingredient ingredient;

    private double price;

    public Supplier_Ingredient() {

    }



    public double getPrice() {
        return price;
    }
}
