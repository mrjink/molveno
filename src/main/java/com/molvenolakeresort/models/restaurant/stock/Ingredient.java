package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.Unit;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Ingredient")
@Table(name = "ingredient")
public class Ingredient {
    @Id @GeneratedValue
    private Long idIngredient;
    private String name;
    private Unit unit;
    private String notes;

    @OneToMany(
        mappedBy = "ingredient",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<SupplyOrderIngredient> supplyOrder_ingredients;

    @OneToMany(
        mappedBy = "ingredient",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<SupplierIngredient> supplier_ingredients;

    @OneToMany(
        mappedBy = "ingredient",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<IngredientMenuItem> ingredient_menuItems;

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

    public List<SupplyOrderIngredient> getSupplyOrder_ingredients() {
        return supplyOrder_ingredients;
    }

    public void setSupplyOrder_ingredients(List<SupplyOrderIngredient> supplyOrder_ingredients) {
        this.supplyOrder_ingredients = supplyOrder_ingredients;
    }

    public List<SupplierIngredient> getSupplier_ingredients() {
        return supplier_ingredients;
    }

    public void setSupplier_ingredients(List<SupplierIngredient> supplier_ingredients) {
        this.supplier_ingredients = supplier_ingredients;
    }

    public List<IngredientMenuItem> getIngredient_menuItems() {
        return ingredient_menuItems;
    }

    public void setIngredient_menuItems(List<IngredientMenuItem> ingredient_menuItems) {
        this.ingredient_menuItems = ingredient_menuItems;
    }
}
