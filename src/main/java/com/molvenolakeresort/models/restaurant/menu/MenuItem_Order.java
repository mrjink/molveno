package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.order.Order;

import javax.persistence.*;

@Entity
public class MenuItem_Order {

    @EmbeddedId
    private MenuItem_Order_Id idMenuItem_Order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMenuItem")
    private MenuItem menuItem;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idOrder")
    private Order order;

    private int quantity;

    public MenuItem_Order() {
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public Order getOrder() {
        return order;
    }

    public MenuItem_Order_Id getIdMenuItem_Order() {
        return idMenuItem_Order;
    }
}
