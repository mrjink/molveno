package com.molvenolakeresort.models.restaurant.menu;

import java.util.List;

import com.molvenolakeresort.models.kitchen.enums.MenuCategory;

public class Menu {
    private int id;
    private MenuCategory category;
    private String name;
    private List<MenuItem> menuItems;
}
