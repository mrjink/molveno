package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.Unit;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Entity
public class Stock {
    @Id
    private Ingredient ingredient;
    private Unit unit;
    private String notes;
    private int quantity;

    public Stock(){

    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
