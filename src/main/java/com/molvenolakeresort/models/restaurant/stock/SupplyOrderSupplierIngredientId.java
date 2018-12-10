package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.Column;
import java.io.Serializable;

public class SupplyOrderSupplierIngredientId implements Serializable {
    @Column(name = "supply_order_id")
    private Long idSupplyOrder;

    @Column(name = "ingredient_id")
    private Long idIngredient;

    @Column(name = "supplier_id")
    private Long idSupplier;

    public SupplyOrderSupplierIngredientId() {
    }


    public SupplyOrderSupplierIngredientId(Long idSupplyOrder, Long idIngredient, Long idSupplier) {
        this.idSupplyOrder = idSupplyOrder;
        this.idIngredient = idIngredient;
        this.idSupplier = idSupplier;
    }

    public Long getIdSupplyOrder() {
        return idSupplyOrder;
    }

    public void setIdSupplyOrder(Long idSupplyOrder) {
        this.idSupplyOrder = idSupplyOrder;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
    }
}
