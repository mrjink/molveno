package com.molvenolakeresort.models.restaurant.order;

import com.molvenolakeresort.models.restaurant.enums.DestinationType;
import com.molvenolakeresort.models.restaurant.enums.SupplierOrderStatus;

import java.util.List;

public class Order {
    private int id;
    private DestinationType destination;
    private String destinationId;
    private List<OrderItem> orderItems;
    private SupplierOrderStatus status;
    private int totalPrice;
}
