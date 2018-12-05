package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.*;

@Entity
public class Supplier_Ingredient {

    @EmbeddedId
    private SupplyOrder_Ingredient_Id idSupplyOrder_ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplier")
    private Supplier supplier;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    private Ingredient ingredient;

    private double price;

    public Supplier_Ingredient() {

    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public double getPrice() {
        return price;
    }

    public SupplyOrder_Ingredient_Id getIdSupplyOrder_ingredient() {
        return idSupplyOrder_ingredient;
    }
}
