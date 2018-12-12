package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.order.Order;

import javax.persistence.*;

@Entity(name = "MenuItemOrder")
@Table(name = "menu_item_order")
public class MenuItemOrder {

    @EmbeddedId
    private MenuItemOrderId idMenuItemOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMenuItem")
    private MenuItem menuItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idOrder")
    private Order order;

    private int quantity;

    public MenuItemOrder() {
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public Order getOrder() {
        return order;
    }

    public MenuItemOrderId getIdMenuItemOrder() {
        return idMenuItemOrder;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
