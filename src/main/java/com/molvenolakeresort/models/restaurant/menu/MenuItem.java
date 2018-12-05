package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.enums.MenuCategory;
import com.molvenolakeresort.models.restaurant.enums.MenuItemType;
import com.molvenolakeresort.models.restaurant.stock.Ingredient;
import com.molvenolakeresort.models.restaurant.stock.Ingredient_MenuItem;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue
    private Long idMenuItem;
    private String name;
    private double price;
    private MenuItemType type;
    private MenuCategory category;
    private String imagePath;
    private boolean availableSeparately;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Ingredient_MenuItemID")
    private Ingredient_MenuItem ingredient_menuItem;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="MenuItemID")
    private MenuItem_Order menuItem_order;

    public MenuItem() {
    }

    public Long getId() {
        return idMenuItem;
    }

    public void setId(long id) {
        this.idMenuItem = id;
    }

    public MenuItemType getType() {
        return type;
    }

    public void setType(MenuItemType type) {
        this.type = type;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Menu> getMenus() {
//        return menus;
//    }
//
//    public void setMenus(List<Menu> menus) {
//        this.menus = menus;
//    }

    public boolean isAvailableSeparately() {
        return availableSeparately;
    }

    public void setAvailableSeparately(boolean availableSeparately) {
        this.availableSeparately = availableSeparately;
    }
}
