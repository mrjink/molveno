package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.*;

@Entity(name = "SupplyOrderSupplierIngredient")
@Table(name = "supply_order_supplier_ingredient")
public class SupplyOrderSupplierIngredient {
//    @EmbeddedId
//    private SupplyOrderSupplierIngredientId idSupplyOrderSupplierIngredient;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("idSupplyOrder")
//    private SupplyOrder supplyOrder;
//
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    private Ingredient ingredient;
//
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplier")
    private Supplier supplier;

    @Id @GeneratedValue
    private Long idSupplyOrderSupplierIngredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplyOrder")
    private SupplyOrder supplyOrder;

    @OneToOne
    private Stock stock;

    private double quantity;

    public SupplyOrderSupplierIngredient() {
    }

    public SupplyOrderSupplierIngredient(Ingredient ingredient, Supplier supplier, double quantity) {
        this.ingredient = ingredient;
        this.supplier = supplier;
        this.quantity = quantity;
    }

//    public SupplyOrderSupplierIngredientId getIdSupplyOrderSupplierIngredient() {
//        return idSupplyOrderSupplierIngredient;
//    }
//
//    public void setIdSupplyOrderSupplierIngredient(SupplyOrderSupplierIngredientId idSupplyOrderSupplierIngredient) {
//        this.idSupplyOrderSupplierIngredient = idSupplyOrderSupplierIngredient;
//    }
//
//    public SupplyOrder getSupplyOrder() {
//        return supplyOrder;
//    }
//
//    public void setSupplyOrder(SupplyOrder supplyOrder) {
//        this.supplyOrder = supplyOrder;
//    }
//
    public Ingredient getIngredient() {
        return ingredient;
    }
//
//    public void setIngredient(Ingredient ingredient) {
//        this.ingredient = ingredient;
//    }
//
    public Supplier getSupplier() {
        return supplier;
    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Long getIdSupplyOrderSupplierIngredient() {
        return idSupplyOrderSupplierIngredient;
    }

    public void setIdSupplyOrderSupplierIngredient(Long idSupplyOrderSupplierIngredient) {
        this.idSupplyOrderSupplierIngredient = idSupplyOrderSupplierIngredient;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public SupplyOrder getSupplyOrder() {
        return supplyOrder;
    }

    public void setSupplyOrder(SupplyOrder supplyOrder) {
        this.supplyOrder = supplyOrder;
    }
}
