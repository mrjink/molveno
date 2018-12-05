package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.*;

@Entity
public class SupplyOrder_Ingredient {
    @EmbeddedId
    private SupplyOrder_Ingredient_Id id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplyOrder")
    private SupplyOrder supplyOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
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

    public SupplyOrder_Ingredient_Id getId() {
        return id;
    }

    public void setId(SupplyOrder_Ingredient_Id id) {
        this.id = id;
    }
}
