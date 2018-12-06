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

    private SupplyOrderSupplierIngredientId() {
    }


    public SupplyOrderSupplierIngredientId(Long idSupplyOrder, Long idIngredient, Long idSupplier) {
        this.idSupplyOrder = idSupplyOrder;
        this.idIngredient = idIngredient;
        this.idSupplier = idSupplier;
    }

    public Long getIdSupplyOrder() {
        return idSupplyOrder;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public Long getIdSupplier() {
        return idSupplier;
    }
}
