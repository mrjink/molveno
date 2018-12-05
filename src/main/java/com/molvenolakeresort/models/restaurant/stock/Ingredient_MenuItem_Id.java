package com.molvenolakeresort.models.restaurant.stock;

import java.io.Serializable;

public class Ingredient_MenuItem_Id implements Serializable {
    private Long idIngredient;
    private Long idMenuItem;

    private Ingredient_MenuItem_Id() {
    }

    public Ingredient_MenuItem_Id(Long idIngredient, Long idMenuItem) {
        this.idIngredient = idIngredient;
        this.idMenuItem = idMenuItem;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public Long getIdMenuItem() {
        return idMenuItem;
    }
}
