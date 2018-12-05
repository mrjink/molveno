package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.enums.MenuCategory;
import com.molvenolakeresort.models.restaurant.enums.MenuItemType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue
    private long idMenuItem;
    private MenuItemType type;
    private MenuCategory category;
    private String imagePath;
    private String description;
    private double price;
    private String name;
//    @ManyToMany(mappedBy = "menuItems")
//    private List<Menu> menus = new ArrayList<>();
//    private Set<Menu> menus;
//    private List<Ingredient> ingredients;
    private boolean availableSeparately;

    public MenuItem() {
    }

    public MenuItem(MenuItemType type, MenuCategory category, String imagePath, String description, double price, String name, boolean availableSeparately) {
        this.type = type;
        this.category = category;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
        this.name = name;
        this.availableSeparately = availableSeparately;
    }

    public long getId() {
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
