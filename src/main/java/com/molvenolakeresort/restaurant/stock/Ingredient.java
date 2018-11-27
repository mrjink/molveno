package com.molvenolakeresort.restaurant.stock;

import com.molvenolakeresort.restaurant.enums.MenuCategory;
import com.molvenolakeresort.restaurant.enums.MenuItemType;
import com.molvenolakeresort.restaurant.enums.Unit;

public class Ingredient {
    private int id;
    private MenuItemType type;
    private String name;
    private Unit unit;
    private MenuCategory category;
    private Supplier supplier;
}
