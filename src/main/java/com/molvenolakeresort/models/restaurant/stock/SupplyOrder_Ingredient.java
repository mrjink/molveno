package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.*;

@Entity(name = "SupplyOrders--Ingredients")
public class SupplyOrder_Ingredient {
    @EmbeddedId
    private SupplyOrder_Ingredient_Id idSupplyOrder_ingredient;

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
        return idSupplyOrder_ingredient;
    }
}
