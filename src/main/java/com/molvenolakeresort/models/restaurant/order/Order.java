package com.molvenolakeresort.models.restaurant.order;

import java.util.List;

import com.molvenolakeresort.models.kitchen.enums.DestinationType;
import com.molvenolakeresort.models.kitchen.enums.Status;

public class Order {
    private int id;
    private DestinationType destination;
    private String destinationId;
    private List<OrderItem> orderItems;
    private Status status;
    private int totalPrice;
}
