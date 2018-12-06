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
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<IngredientMenuItem> ingredientMenuItems;
    private boolean availableSeparately;

    public MenuItem() {
    }

    public Long getId() {
        return idMenuItem;
    }

    //This ID can be set to put an existing menu item into a menu.
    public void setIdMenuItem(Long idMenuItem) {
        this.idMenuItem = idMenuItem;
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

    public boolean isAvailableSeparately() {
        return availableSeparately;
    }

    public void setAvailableSeparately(boolean availableSeparately) {
        this.availableSeparately = availableSeparately;
    }

    public List<IngredientMenuItem> getIngredientMenuItems() {
        return ingredientMenuItems;
    }

    public void setIngredientMenuItems(List<IngredientMenuItem> ingredientMenuItems) {
        this.ingredientMenuItems = ingredientMenuItems;
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
}
