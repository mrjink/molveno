package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.menu.MenuItem;

import javax.persistence.*;

@Entity(name = "Ingredients--MenuItems")
public class Ingredient_MenuItem {
    @EmbeddedId
    private Ingredient_MenuItem_Id idIngredientMenuItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplyOrder")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    private MenuItem menuItem;

    private double quantity;

    public Ingredient_MenuItem() {

    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public double getQuantity() {
        return quantity;
    }
}
