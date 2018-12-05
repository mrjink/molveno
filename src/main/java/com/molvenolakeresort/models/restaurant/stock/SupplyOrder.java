package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.SupplierOrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class SupplyOrder {
    @Id @GeneratedValue
    private Long idSupplyOrder;
    private Date deliveryDate;
    private Date orderDate;
    private SupplierOrderStatus supplierOrderStatus;

    @OneToMany
    private List<SupplyOrder_Ingredient> supplyOrder_ingredients;

    public SupplyOrder() {

    }

    public Long getIdSupplyOrder() {
        return idSupplyOrder;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public SupplierOrderStatus getSupplierOrderStatus() {
        return supplierOrderStatus;
    }

    public List<SupplyOrder_Ingredient> getSupplyOrder_ingredients() {
        return supplyOrder_ingredients;
    }
}
