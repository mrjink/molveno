package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.Unit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Unit unit;
    private String notes;

    public Ingredient(){}

//    private Supplier supplier;

//    public Ingredient( String name, Unit unit, Supplier supplier, String notes) {
//        this.name = name;
//        this.unit = unit;
////        this.supplier = supplier;
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
