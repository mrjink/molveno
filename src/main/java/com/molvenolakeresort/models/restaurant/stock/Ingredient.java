package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.MenuCategory;
import com.molvenolakeresort.models.restaurant.enums.MenuItemType;
import com.molvenolakeresort.models.restaurant.enums.Unit;

public class Ingredient {
    private int id;
    private MenuItemType type;
    private String name;
    private Unit unit;
    private MenuCategory category;
    private Supplier supplier;
}
