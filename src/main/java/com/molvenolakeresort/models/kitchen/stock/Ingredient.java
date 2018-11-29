package com.molvenolakeresort.models.kitchen.stock;

import com.molvenolakeresort.models.kitchen.enums.MenuCategory;
import com.molvenolakeresort.models.kitchen.enums.MenuItemType;
import com.molvenolakeresort.models.kitchen.enums.Unit;

public class Ingredient {
    private int id;
    private MenuItemType type;
    private String name;
    private Unit unit;
    private MenuCategory category;
    private Supplier supplier;
}
