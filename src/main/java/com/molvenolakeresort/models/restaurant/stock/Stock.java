package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.Unit;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Stock {

    public Stock(String name, Unit unit, Supplier supplier, String notes) {
    }

    private int id;
    private LinkedHashMap<Ingredient, Integer> ingredients;

    private List<Ingredient> Stock = new ArrayList();

    private void addToStock(Ingredient ingredient, double amount) {
        if (Stock.contains(ingredient)) {
//            double inStock = getAmount();
//            setAmount(inStock + amount);
        }

    }

    private void getOutStock(Ingredient ingredient, double amount) {
//
    }
}
