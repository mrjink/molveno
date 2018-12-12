package com.molvenolakeresort.models.restaurant.dto;

import com.molvenolakeresort.models.restaurant.enums.Unit;
import com.molvenolakeresort.models.restaurant.stock.Ingredient;

public class StockDTO
{
    private Ingredient ingredient;
    private Unit unit;
    private String notes;
    private int quantity;

    public StockDTO(){}

    public StockDTO(Ingredient ingredient, Unit unit, String notes, int quantity) {
        this.ingredient = ingredient;
        this.unit = unit;
        this.notes = notes;
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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
