package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.*;

@Entity(name = "SupplyOrderIngredient")
@Table(name = "supply_order_ingredient")
public class SupplyOrderIngredient {
    @EmbeddedId
    private SupplyOrderIngredientId idSupplyOrderIngredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplyOrder")
    private SupplyOrder supplyOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    private Ingredient ingredient;

    private double quantity;

    public SupplyOrderIngredient() {
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

    public SupplyOrderIngredientId getId() {
        return idSupplyOrderIngredient;
    }
}
