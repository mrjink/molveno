package com.molvenolakeresort.restaurant.menu;

import com.molvenolakeresort.restaurant.enums.MenuCategory;
import com.molvenolakeresort.restaurant.enums.MenuItemType;
import com.molvenolakeresort.restaurant.stock.Ingredient;

import java.util.List;

public class MenuItem {
    private int id;
    private MenuItemType type;
    private MenuCategory category;
    private String imagePath;
    private String description;
    private double price;
    private String name;
    private List<Ingredient> ingredients;
    private boolean availableSeparately;

    public MenuItem(int id, MenuItemType type, MenuCategory category, String imagePath, String description, double price, String name, List<Ingredient> ingredients, boolean availableSeparately) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
        this.name = name;
        this.ingredients = ingredients;
        this.availableSeparately = availableSeparately;
    }

    //    opm: belangrijk dat al het eten via restaurant wordt besteld en al het drinken namens bar.
//        indien er dus voor bar eten moet worden besteld doet de FoH dit via restaurant

}
