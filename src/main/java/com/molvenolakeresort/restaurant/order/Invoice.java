package com.molvenolakeresort.restaurant.order;

import java.time.LocalDateTime;

import com.molvenolakeresort.models.kitchen.temp.User;
import com.molvenolakeresort.models.restaurant.order.Order;

public class Invoice {
    private int id;
    private User user;
    private Order order;

    private LocalDateTime created;

}
