package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.stock.Ingredient;

import javax.persistence.Entity;

@Entity
public class IngredientMenuItem
{
    private MenuItem menuItem;
    private Ingredient ingredient;
    private int quantity;


}
