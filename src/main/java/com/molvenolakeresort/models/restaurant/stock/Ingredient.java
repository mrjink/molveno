package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.Unit;
import com.molvenolakeresort.models.restaurant.menu.MenuItem;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private int id;
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

//    public Ingredient( String name, Unit unit, Supplier supplier, String notes) {
//        this.name = name;
//        this.unit = unit;
//        //this.supplier = supplier;
//        this.notes=notes;
//    }

    public int getId() {
        return id;
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


//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
