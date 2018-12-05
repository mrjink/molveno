package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SupplyOrder_Ingredient {
    @Id
    private SupplyOrder supplyOrder;
    @Id
    private Ingredient ingredient;

    private double quantity;

    public SupplyOrder_Ingredient() {
    }

    public SupplyOrder getSupplyOrder() {
        return supplyOrder;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public double getQuantity() {
        return quantity;
    }
}
