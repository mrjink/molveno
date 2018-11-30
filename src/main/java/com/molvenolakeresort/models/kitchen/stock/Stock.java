package com.molvenolakeresort.models.kitchen.stock;

import com.molvenolakeresort.restaurant.enums.Unit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Stock extends Ingredient {

    public Stock(String name, Unit unit, Supplier supplier, String notes) {
        super(name, unit, supplier, notes);
    }

    private int id;
    private LinkedHashMap<Ingredient, Integer> ingredients;

    private List<Ingredient> Stock = new ArrayList();

    private void addToStock(Ingredient ingredient, double amount) {
        if (Stock.contains(ingredient)) {
            double inStock = getAmount();
            setAmount(inStock + amount);
        }

    }

    private void getOutStock(Ingredient ingredient, double amount) {
        if (Stock.contains(ingredient)) {
            double inStock = getAmount();
            if (inStock - amount < 0) {
                System.out.println("Too little in stock!");
            } else {
                setAmount(inStock - amount);
            }

        } else {
            System.out.println(ingredient + "is not in stock.");
        }
    }
}
