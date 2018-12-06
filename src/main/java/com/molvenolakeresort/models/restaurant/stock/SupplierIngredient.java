package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.*;

@Entity(name = "SupplierIngredient")
@Table(name = "supplier_ingredient")
public class SupplierIngredient {

    @EmbeddedId
    private SupplyOrderIngredientId idSupplyOrderIngredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplier")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    private Ingredient ingredient;

    private double price;

    public SupplierIngredient() {

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

    public SupplyOrderIngredientId getIdSupplyOrderIngredient() {
        return idSupplyOrderIngredient;
    }
}
