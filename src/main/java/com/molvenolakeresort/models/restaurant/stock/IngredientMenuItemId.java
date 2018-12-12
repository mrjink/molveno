package com.molvenolakeresort.models.restaurant.stock;

import javax.persistence.Column;
import java.io.Serializable;

public class IngredientMenuItemId implements Serializable {
    @Column(name = "ingredient_id")
    private Long idIngredient;

    @Column(name = "menu_item_id")
    private Long idMenuItem;

    private IngredientMenuItemId() {
    }

    public IngredientMenuItemId(Long idIngredient, Long idMenuItem) {
        this.idIngredient = idIngredient;
        this.idMenuItem = idMenuItem;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public Long getIdMenuItem() {
        return idMenuItem;
    }
}
