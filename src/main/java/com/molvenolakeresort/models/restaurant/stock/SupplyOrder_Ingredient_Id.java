package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.Column;
import java.io.Serializable;

public class SupplyOrder_Ingredient_Id implements Serializable {
    private Long idSupplyOrder;
    private Long idIngredient;

    private SupplyOrder_Ingredient_Id() {
    }

    public SupplyOrder_Ingredient_Id(Long idSupplyOrder, Long idIngredient) {
        this.idSupplyOrder = idSupplyOrder;
        this.idIngredient = idIngredient;
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
}
