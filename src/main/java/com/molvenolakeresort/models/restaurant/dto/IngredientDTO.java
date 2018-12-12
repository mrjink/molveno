package com.molvenolakeresort.models.restaurant.dto;

import com.molvenolakeresort.models.restaurant.stock.IngredientMenuItem;
import com.molvenolakeresort.models.restaurant.stock.SupplyOrderSupplierIngredient;

import java.util.List;

public class IngredientDTO
{
    private String name;
    private String unit;
    private String notes;
    private List<SupplyOrderSupplierIngredient> supplyOrderSupplierIngredients;
    private List<SupplyOrderSupplierIngredient> supplierIngredients;
    private List<IngredientMenuItem> ingredientMenuItems;

    public List<IngredientMenuItem> getIngredientMenuItems() {
        return ingredientMenuItems;
    }

    public void setIngredientMenuItems(List<IngredientMenuItem> ingredientMenuItems) {
        this.ingredientMenuItems = ingredientMenuItems;
    }

    public List<SupplyOrderSupplierIngredient> getSupplierIngredients() {
        return supplierIngredients;
    }

    public void setSupplierIngredients(List<SupplyOrderSupplierIngredient> supplierIngredients) {
        this.supplierIngredients = supplierIngredients;
    }

    public String getName() {
        return name;
    }

    public List<SupplyOrderSupplierIngredient> getSupplyOrderSupplierIngredients() {
        return supplyOrderSupplierIngredients;
    }

    public void setSupplyOrderSupplierIngredients(List<SupplyOrderSupplierIngredient> supplyOrderSupplierIngredients) {
        this.supplyOrderSupplierIngredients = supplyOrderSupplierIngredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
