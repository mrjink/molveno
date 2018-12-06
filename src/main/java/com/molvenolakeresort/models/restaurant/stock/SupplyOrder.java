package com.molvenolakeresort.models.restaurant.stock;

import com.molvenolakeresort.models.restaurant.enums.SupplierOrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "SupplyOrder")
@Table(name = "supply_order")
public class SupplyOrder {
    @Id @GeneratedValue
    private Long idSupplyOrder;
    private Date deliveryDate;
    private Date orderDate;
    private SupplierOrderStatus supplierOrderStatus;

    @OneToMany(
        mappedBy = "supplyOrder",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<SupplyOrderSupplierIngredient> supplyOrderSupplierIngredients;

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

    public List<SupplyOrderSupplierIngredient> getSupplyOrderSupplierIngredients() {
        return supplyOrderSupplierIngredients;
    }
}
