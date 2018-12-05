package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.Unit;
import com.molvenolakeresort.models.restaurant.menu.MenuItem;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Ingredients")
public class Ingredient {
    @Id @GeneratedValue
    private Long idIngredient;
    private String name;
    private Unit unit;
    private String notes;

    @OneToMany
    private List<SupplyOrder_Ingredient> supplyOrder_ingredients;

    @OneToMany
    private List<Supplier_Ingredient> supplier_ingredients;

    @OneToMany
    private List<Ingredient_MenuItem> ingredient_menuItems;

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

    public Long getIdIngredient() {
        return idIngredient;
    }

    public List<SupplyOrder_Ingredient> getSupplyOrder_ingredients() {
        return supplyOrder_ingredients;
    }

    public void setSupplyOrder_ingredients(List<SupplyOrder_Ingredient> supplyOrder_ingredients) {
        this.supplyOrder_ingredients = supplyOrder_ingredients;
    }

    public List<Supplier_Ingredient> getSupplier_ingredients() {
        return supplier_ingredients;
    }

    public void setSupplier_ingredients(List<Supplier_Ingredient> supplier_ingredients) {
        this.supplier_ingredients = supplier_ingredients;
    }

    public List<Ingredient_MenuItem> getIngredient_menuItems() {
        return ingredient_menuItems;
    }

    public void setIngredient_menuItems(List<Ingredient_MenuItem> ingredient_menuItems) {
        this.ingredient_menuItems = ingredient_menuItems;
    }
}
