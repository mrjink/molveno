package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.enums.MenuCategory;

import java.util.List;

public class Menu {
    private int id;
    private MenuCategory category;
    private String name;
    private List<MenuItem> menuItems;
}
