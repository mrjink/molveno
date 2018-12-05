package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.Unit;
import com.molvenolakeresort.models.restaurant.menu.MenuItem;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private Long idIngredient;
    private String name;
    private Unit unit;
    private String notes;

    @OneToMany
    private SupplyOrder_Ingredient supplyOrder_ingredient;

    @OneToMany
    private Supplier_Ingredient supplier_ingredient;

    @OneToMany
    private Ingredient_MenuItem ingredient_menuItem;
//    private Supplier supplier;

    public Ingredient() {
    }

    public Long getId() {
        return idIngredient;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
