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
    private List<SupplyOrderSupplierIngredient> supplyOrderSupplierIngredients;

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

    public Long getID() {
        return idIngredient;
    }

    public void setID(Long idIngredient) {
        this.idIngredient = idIngredient;
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

        System.out.println("Set unit: "+unit);

        this.unit = unit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<SupplyOrderSupplierIngredient> getSupplyOrderSupplierIngredients() {
        return supplyOrderSupplierIngredients;
    }

    public void setSupplyOrderSupplierIngredients(List<SupplyOrderSupplierIngredient> supplyOrderSupplierIngredients) {
        this.supplyOrderSupplierIngredients = supplyOrderSupplierIngredients;
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
