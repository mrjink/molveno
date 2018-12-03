package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.SupplierOrderStatus;

import java.util.Date;
import java.util.List;

public class SupplyOrder {
    private SupplierOrderStatus supplierOrderStatus;
    private List<SupplyOrderItem> supplyOrderItems;
    private Supplier supplier;
    private Date deliveryDate;
    private Date orderDate;
}
