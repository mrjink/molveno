package com.molvenolakeresort.models.restaurant.order;

import com.molvenolakeresort.restaurant.enums.DestinationType;
import com.molvenolakeresort.restaurant.enums.Status;

import java.util.List;

public class Order {
    private int id;
    private DestinationType destination;
    private String destinationId;
    private List<OrderItem> orderItems;
    private Status status;
    private int totalPrice;
}
