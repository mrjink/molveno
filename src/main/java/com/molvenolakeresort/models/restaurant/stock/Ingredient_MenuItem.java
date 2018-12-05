package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.menu.MenuItem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient_MenuItem {

    @Id
    private Ingredient ingredient;
    @Id
    private MenuItem menuItem;

    private double quantity;

    public Ingredient_MenuItem() {

    }
}
