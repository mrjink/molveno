package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.*;

@Entity(name = "SupplyOrderSupplierIngredient")
@Table(name = "supply_order_supplier_ingredient")
public class SupplyOrderSupplierIngredient {
    @EmbeddedId
    private SupplyOrderSupplierIngredientId idSupplyOrderSupplierIngredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplyOrder")
    private SupplyOrder supplyOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplier")
    private Supplier supplier;

    private double quantity;

    public SupplyOrderSupplierIngredient() {
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

    public SupplyOrderSupplierIngredientId getId() {
        return idSupplyOrderSupplierIngredient;
    }

    public SupplyOrderSupplierIngredientId getIdSupplyOrderSupplierIngredient() {
        return idSupplyOrderSupplierIngredient;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
