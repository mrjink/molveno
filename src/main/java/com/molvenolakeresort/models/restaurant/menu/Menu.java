package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.enums.MenuCategory;
import com.molvenolakeresort.models.restaurant.enums.MenuItemType;

import javax.persistence.*;
import java.util.List;

// This is not a menu carte.
// This is a collection of items that the guest can order, like a happy meal!
@Entity(name = "Menu")
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long idMenu;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<MenuItem> menuItem;
    //Name of menuItem bundle
    private String name;
    private MenuCategory category;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@ManyToMany(cascade = CascadeType.ALL)
    //@JoinTable(name = "menu_menu_items", joinColumns = @JoinColumn(name = "idMenu"), inverseJoinColumns = @JoinColumn(name = "idMenuItem"))

    //private List<MenuItem> menuItems = new ArrayList<>();


    public Menu() {
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

    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(List<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
