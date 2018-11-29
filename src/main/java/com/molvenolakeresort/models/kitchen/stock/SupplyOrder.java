package com.molvenolakeresort.models.kitchen.stock;

import java.util.Date;
import java.util.List;

import com.molvenolakeresort.models.kitchen.enums.Status;

public class SupplyOrder {
    private Status status;
    private List<SupplyOrderItem> supplyOrderItems;
    private Supplier supplier;
    private Date deliveryDate;
    private Date orderDate;
}
