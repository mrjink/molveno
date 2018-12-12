package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.Column;
import java.io.Serializable;

public class SupplyOrderIngredientId implements Serializable {
    @Column(name = "supply_order_id")
    private Long idSupplyOrder;

    @Column(name = "ingredient_id")
    private Long idIngredient;

    private SupplyOrderIngredientId() {
    }

    public SupplyOrderIngredientId(Long idSupplyOrder, Long idIngredient) {
        this.idSupplyOrder = idSupplyOrder;
        this.idIngredient = idIngredient;
    }

    public Long getIdSupplyOrder() {
        return idSupplyOrder;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }
}
