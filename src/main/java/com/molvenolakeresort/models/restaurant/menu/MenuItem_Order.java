package com.molvenolakeresort.models.restaurant.menu;

import com.molvenolakeresort.models.restaurant.order.Order;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuItem_Order {

    @Id
    private MenuItem menuItem;
    @Id
    private Order order;

    private int quantity;

    public MenuItem_Order() {
    }

}
