package com.molvenolakeresort.models.kitchen.stock;

import com.molvenolakeresort.restaurant.enums.Status;

import java.util.Date;
import java.util.List;

public class SupplyOrder {
    private Status status;
    private List<SupplyOrderItem> supplyOrderItems;
    private Supplier supplier;
    private Date deliveryDate;
    private Date orderDate;
}
