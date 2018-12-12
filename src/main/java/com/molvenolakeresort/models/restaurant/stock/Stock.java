package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Stock")
@Table(name = "stock")
@IdClass(Stock.StockId.class)
public class Stock implements Serializable{

//    @EmbeddedId
//    private SupplyOrderSupplierIngredientId idSupplyOrderIngredient;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSupplier")
    private Supplier supplier;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idIngredient")
    private Ingredient ingredient;

    private double price;

    private int quantity;

    public Stock() {

    }

    public static class StockId implements Serializable {

        private Supplier supplier;
        private Ingredient ingredient;

        public StockId() {
        }

        public StockId(Supplier supplier, Ingredient ingredient) {
            this.supplier = supplier;
            this.ingredient = ingredient;
        }
    }

//    public SupplyOrderSupplierIngredientId getIdSupplyOrderIngredient() {
//        return idSupplyOrderIngredient;
//    }
//
//    public void setIdSupplyOrderIngredient(SupplyOrderSupplierIngredientId idSupplyOrderIngredient) {
//        this.idSupplyOrderIngredient = idSupplyOrderIngredient;
//    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
