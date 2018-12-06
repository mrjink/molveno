package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.enums.MenuCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "Menu")
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long idMenu;
    private MenuCategory category;
    private String name;
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToMany
    @JoinTable(name = "menu_menu_items", joinColumns = @JoinColumn(name = "idMenu"), inverseJoinColumns = @JoinColumn(name = "idMenuItem"))
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu() {
    }

    public Menu(MenuCategory category, String name, List<MenuItem> menuItems) {
        this.category = category;
        this.name = name;
        this.menuItems = menuItems;
    }

    public Long getId() {
        return idMenu;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
