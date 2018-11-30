package com.molvenolakeresort.models.kitchen.stock;

import com.molvenolakeresort.restaurant.enums.MenuCategory;
import com.molvenolakeresort.restaurant.enums.MenuItemType;
import com.molvenolakeresort.restaurant.enums.Unit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private int id;
    private MenuItemType type;
    private String name;
    private Unit unit;
    private MenuCategory category;
    private Supplier supplier;

    public Ingredient( MenuItemType type, String name, Unit unit, MenuCategory category, Supplier supplier) {
        this.type = type;
        this.name = name;
        this.unit = unit;
        this.category = category;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }
    

    public MenuItemType getType() {
        return type;
    }

    public void setType(MenuItemType type) {
        this.type = type;
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

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
