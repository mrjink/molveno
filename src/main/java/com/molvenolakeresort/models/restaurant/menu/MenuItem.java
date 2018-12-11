package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.enums.MenuCategory;
import com.molvenolakeresort.models.restaurant.enums.MenuItemType;
import com.molvenolakeresort.models.restaurant.stock.IngredientMenuItem;

import javax.persistence.*;
import java.util.List;

@Entity(name = "MenuItems")
@Table(name = "menu_item")
public class MenuItem {
    @Id
    @GeneratedValue
    private Long idMenuItem;
    private String name;
    private String description;
    private String imagePath;
    private double price;
    private MenuCategory category;
    private MenuItemType type;
    @OneToMany(
        mappedBy = "menuItem",
        cascade = CascadeType.REMOVE,
        orphanRemoval = true
    )
    private List<IngredientMenuItem> ingredientMenuItems;

    @OneToMany(
            mappedBy = "menuItem",
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    private List<IngredientMenuItem> menus;
    private boolean availableSeparately;

    public MenuItem() {
    }

    public Long getIdMenuItem() {
        return idMenuItem;
    }

    public void setIdMenuItem(Long idMenuItem) {
        this.idMenuItem = idMenuItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public MenuItemType getType() {
        return type;
    }

    public void setType(MenuItemType type) {
        this.type = type;
    }

    public List<IngredientMenuItem> getIngredientMenuItems() {
        return ingredientMenuItems;
    }

    public void setIngredientMenuItems(List<IngredientMenuItem> ingredientMenuItems) {
        this.ingredientMenuItems = ingredientMenuItems;
    }

    public List<IngredientMenuItem> getMenus() {
        return menus;
    }

    public void setMenus(List<IngredientMenuItem> menus) {
        this.menus = menus;
    }

    public boolean isAvailableSeparately() {
        return availableSeparately;
    }

    public void setAvailableSeparately(boolean availableSeparately) {
        this.availableSeparately = availableSeparately;
    }
}
