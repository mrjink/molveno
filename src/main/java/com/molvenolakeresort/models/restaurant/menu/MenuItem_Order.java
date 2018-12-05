package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.order.Order;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuItem_Order {

    @Id
    private MenuItem idMenuItem_Order;
    @Id
    private Order order;

    private int quantity;

    public MenuItem_Order() {
    }

    public MenuItem getIdMenuItem_Order() {
        return idMenuItem_Order;
    }

    public Order getOrder() {
        return order;
    }
}
