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
    private List<SupplyOrderIngredient> supplyOrderIngredients;

    @OneToMany(
        mappedBy = "ingredient",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<SupplierIngredient> supplierIngredients;

    @OneToMany(
        mappedBy = "ingredient",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<IngredientMenuItem> ingredientMenuItems;

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

    public List<SupplyOrderIngredient> getSupplyOrderIngredients() {
        return supplyOrderIngredients;
    }

    public void setSupplyOrderIngredients(List<SupplyOrderIngredient> supplyOrderIngredients) {
        this.supplyOrderIngredients = supplyOrderIngredients;
    }

    public List<SupplierIngredient> getSupplierIngredients() {
        return supplierIngredients;
    }

    public void setSupplierIngredients(List<SupplierIngredient> supplierIngredients) {
        this.supplierIngredients = supplierIngredients;
    }

    public List<IngredientMenuItem> getIngredientMenuItems() {
        return ingredientMenuItems;
    }

    public void setIngredientMenuItems(List<IngredientMenuItem> ingredientMenuItems) {
        this.ingredientMenuItems = ingredientMenuItems;
    }
}
