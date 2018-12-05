package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.SupplierOrderStatus;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class SupplyOrder {
    private Date deliveryDate;
    private Date orderDate;
    private SupplierOrderStatus supplierOrderStatus;

    @OneToMany
    private SupplyOrder_Ingredient supplyOrder_ingredient;

    public SupplyOrder() {

    }
}
