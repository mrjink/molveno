package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.menu.MenuItem;

import javax.persistence.*;

@Entity(name = "IngredientMenuItem")
@Table(name = "ingredient_menu_item")
public class IngredientMenuItem {
    @EmbeddedId
    private IngredientMenuItemId idIngredientMenuItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMenuItem")
    private MenuItem menuItem;

    private double quantity;

    public IngredientMenuItem() {

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
